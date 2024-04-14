package wannabe.backend.core.oauth2.adapter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.OperationNotSupportedException;
import lombok.val;
import okhttp3.OkHttpClient;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import wannabe.backend.core.oauth2.OAuth2ArgumentChooserService;
import wannabe.backend.core.oauth2.OAuth2ArgumentPort;
import wannabe.backend.core.oauth2.OAuth2ProviderValues;
import wannabe.backend.core.oauth2.OAuth2ProviderValues.Provider;
import wannabe.backend.core.oauth2.OAuth2ProviderValues.Registration;
import wannabe.backend.core.oauth2.port.OAuth2ErrorPort;

/**
 * 아래 링크를 통해 code를 얻고 테스트를 실행해야 합니다. <p>
 * code는 일회성 이기 때문에 테스트할 때마다 재발급 받으셔야 합니다. <p>
 * <a href="http://localhost:8080/oauth2/authorization/kakao">kakao</a>
 */
@Disabled("code를 kakao로 부터 얻어서 사용하세요!")
@ExtendWith(MockitoExtension.class)
class OAuth2MemberInfoResolverTest {

  private final OAuth2ArgumentChooserService chooser = mock(OAuth2ArgumentChooserService.class);
  private final OkHttpClient client = new OkHttpClient();
  private final ObjectMapper mapper = new ObjectMapper();
  private final OAuth2ErrorPort errorPort = mock(OAuth2ErrorPort.class);
  private final OAuth2MemberFactory oAuth2MemberFactory = new OAuth2MemberFactory();
  private final OAuth2MemberInfoResolver resolver
      = new OAuth2MemberInfoResolver(chooser, client, mapper, errorPort, oAuth2MemberFactory);

  // http://localhost:8080/login/oauth2/code/kakao?code=lPzBGFRzgRyAS36oPVOHSnUeXoD-0sQ2wsG_hgXGveJz4NOcYQnXAFcJNpIKPXLqAAABjt2iKRiGtS2__sNdBQ&state=kakao,8e493eda-c2c8-4d73-b3fa-af6f505d5eed

  // OAuth2AccessToken[ OAuth2AccessToken[tokenType=bearer,
  // accessToken=8580Rar7pAHO4XzkaQduzlvWyHKAfFEo4vkKKiUNAAABjt255A3mTYKY7N6ACw, idToken=null,
  // expiresIn=21599, refreshToken=Do0SWwv_5pdEdcvJ1ExpxP2XSDz5Y4w1eikKKiUNAAABjt255AnmTYKY7N6ACw,
  // refreshTokenExpiresIn=5183999, scope=age_range birthday account_email birthyear
  // profile_nickname name phone_number, error=null, errorDescription=null, errorCode=null]
  @Test
  void kakao에서_액세스_토큰_얻기() throws OperationNotSupportedException {
    // given
    val argumentPort = mock(OAuth2ArgumentPort.class);
    when(chooser.choose(anyString())).thenReturn(argumentPort);
    when(argumentPort.client()).thenReturn(FakeOAuth2ProviderValuesFactory.create());
    // when
    val token = resolver.accessToken("kakao",
        "JPCNU8ez8OGIC29iiJUceaOqO1vzNzFV2r5O66Bh0FlC5TiugkySkPwN_MsKPXLrAAABjt25bqV-jFVpBnvzXw",
        "kakao,8e493eda-c2c8-4d73-b3fa-af6f505d5eed");
    // then
    assertThat(token).isNotNull();
  }

  private static class FakeOAuth2ProviderValuesFactory {

    private static OAuth2ProviderValues create() {
      return OAuth2ProviderValues.builder()
          .registration(Registration.builder()
              .tokenGrantType("authorization_code")
              .clientId("17e562df562af0446691a84a7846c65f")
              .redirectUri("http://localhost:8080/login/oauth2/code/kakao")
              .clientSecret("vgdNT7OIaz")
              .build())
          .provider(Provider.builder()
              .tokenUri("https://kauth.kakao.com/oauth/token")
              .build())
          .build();
    }
  }
}