package wannabe.backend.core.oauth2.adapter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import javax.naming.OperationNotSupportedException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import wannabe.backend.core.oauth2.OAuth2ArgumentChooserService;
import wannabe.backend.core.oauth2.OAuth2ArgumentPort;
import wannabe.backend.core.oauth2.Provider;
import wannabe.backend.core.oauth2.port.OAuth2ErrorPort;

@Service
@RequiredArgsConstructor
public class OAuth2MemberInfoResolver implements OAuth2MemberInfoGateway {

  private final OAuth2ArgumentChooserService chooser;
  private final OkHttpClient httpClient;
  private final ObjectMapper objectMapper;
  private final OAuth2ErrorPort errorPort;
  private final OAuth2MemberFactory oAuth2MemberFactory;

  @Override
  public OAuth2Member resolve(@NonNull OAuth2Request request) {
    val accessToken = accessToken(request.registrationId(), request.code(), request.state());

    val argumentPort = argumentPort(request.registrationId());

    val httpRequest = new Builder()
        .url(argumentPort.client().provider().userInfoUri())
        .addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken)
        .build();

    try (val res = httpClient.newCall(httpRequest).execute()) {
      if (res.body() == null) {
        throw new IllegalCallerException("kakao 토큰 응답이 잘못되었습니다 : " + res);
      }

      val bodyString = res.body().byteString().string(StandardCharsets.UTF_8);
      val resBody = objectMapper.readValue(bodyString,
          new TypeReference<Map<String, Object>>() {});

      errorPort.receive(request.registrationId(), res.code(), resBody);

      return oAuth2MemberFactory.create(request.registrationId(), resBody);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * 카카오에서 토큰 발급 받기
   * @param registrationId KAKAO
   * @param code 카카오에서 인가 코드 받은 후 callback uri에 같이 오는 code
   * @param state 카카오에 보내는 request 마다 고유한 값
   * @return 카카오에서 받은 액세스 토큰
   */
  @Override
  public String accessToken(@NonNull Provider registrationId, @NonNull String code,
      @NonNull String state) {

    val argumentPort = argumentPort(registrationId);

    val formBody = new FormBody.Builder()
        .add("grant_type", argumentPort.client().registration().tokenGrantType())
        .add("client_id", argumentPort.client().registration().clientId())
        .add("redirect_uri", argumentPort.client().registration().redirectUri())
        .add("code", code)
        .add("client_secret", argumentPort.client().registration().clientSecret())
        .add("state", state)
        .build();

    val request = new Request.Builder()
        .url(argumentPort.client().provider().tokenUri())
        .addHeader("content-type", MediaType.APPLICATION_FORM_URLENCODED_VALUE)
        .post(formBody)
        .build();

    try (val res = httpClient.newCall(request).execute()) {
      if (res.body() == null) {
        throw new IllegalCallerException(registrationId + " 토큰 응답이 잘못되었습니다 : " + res);
      }

      val bodyString = res.body().byteString().string(StandardCharsets.UTF_8);
      val token = objectMapper.readValue(bodyString,
          new TypeReference<OAuth2AccessToken>() {
          });

      return token.accessToken();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private OAuth2ArgumentPort argumentPort(@NonNull Provider registrationId) {
    try {
      return chooser.choose(registrationId);
    } catch (OperationNotSupportedException e) {
      throw new IllegalArgumentException(e);
    }
  }
}
