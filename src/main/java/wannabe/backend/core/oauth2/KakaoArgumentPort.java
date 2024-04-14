package wannabe.backend.core.oauth2;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import wannabe.backend.core.oauth2.OAuth2ProviderValues.Provider;
import wannabe.backend.core.oauth2.OAuth2ProviderValues.Registration;

@Service
public class KakaoArgumentPort implements OAuth2ArgumentPort {

  @Value("${spring.security.oauth2.client.registration.kakao.provider}")
  private String provider;

  @Value("${spring.security.oauth2.client.registration.kakao.client-id}")
  private String clientId;

  @Value("${spring.security.oauth2.client.registration.kakao.redirect-uri}")
  private String redirectUri;

  @Value("${spring.security.oauth2.client.registration.kakao.token-grant-type}")
  private String tokenGrantType;

  @Value("${spring.security.oauth2.client.registration.kakao.authorization-response-type}")
  private String authorizationResponseType;

  @Value("${spring.security.oauth2.client.registration.kakao.client-secret}")
  private String clientSecret;

  @Value("${spring.security.oauth2.client.registration.kakao.scope}")
  private String[] scope;

  @Value("${spring.security.oauth2.client.provider.kakao.authorization-uri}")
  private String authorizationUri;

  @Value("${spring.security.oauth2.client.provider.kakao.token-uri}")
  private String tokenUri;

  @Override
  public OAuth2ProviderValues client() {
    return OAuth2ProviderValues.builder()
        .registration(Registration.builder()
            .provider(provider)
            .clientId(clientId)
            .redirectUri(redirectUri)
            .tokenGrantType(tokenGrantType)
            .authorizationResponseType(authorizationResponseType)
            .clientSecret(clientSecret)
            .scope(Arrays.stream(scope).toList())
            .build())
        .provider(Provider.builder()
            .authorizationUri(authorizationUri)
            .tokenUri(tokenUri)
            .build())
        .build();
  }
}
