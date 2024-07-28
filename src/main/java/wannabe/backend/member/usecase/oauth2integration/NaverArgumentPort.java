package wannabe.backend.member.usecase.oauth2integration;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import wannabe.backend.member.usecase.oauth2integration.OAuth2ProviderValues.Provider;
import wannabe.backend.member.usecase.oauth2integration.OAuth2ProviderValues.Registration;

@Service
public class NaverArgumentPort implements OAuth2ArgumentPort {

  @Value("${spring.security.oauth2.client.registration.naver.provider}")
  private String provider;

  @Value("${spring.security.oauth2.client.registration.naver.client-id}")
  private String clientId;

  @Value("${spring.security.oauth2.client.registration.naver.redirect-uri}")
  private String redirectUri;

  @Value("${spring.security.oauth2.client.registration.naver.token-grant-type}")
  private String tokenGrantType;

  @Value("${spring.security.oauth2.client.registration.naver.authorization-response-type}")
  private String authorizationResponseType;

  @Value("${spring.security.oauth2.client.registration.naver.client-secret}")
  private String clientSecret;

  @Value("${spring.security.oauth2.client.registration.naver.scope}")
  private String[] scope;

  @Value("${spring.security.oauth2.client.provider.naver.authorization-uri}")
  private String authorizationUri;

  @Value("${spring.security.oauth2.client.provider.naver.token-uri}")
  private String tokenUri;

  @Value("${spring.security.oauth2.client.provider.naver.user-info-uri}")
  private String userInfoUri;

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
            .userInfoUri(userInfoUri)
            .build())
        .build();
  }
}
