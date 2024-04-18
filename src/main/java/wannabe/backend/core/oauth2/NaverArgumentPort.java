package wannabe.backend.core.oauth2;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import wannabe.backend.core.oauth2.OAuth2ProviderValues.Provider;
import wannabe.backend.core.oauth2.OAuth2ProviderValues.Registration;

@Service
public class NaverArgumentPort implements OAuth2ArgumentPort {

  @Value("${spring.security.oauth2.client.registration.naver.provider}")
  private String provider;

  @Value("${spring.security.oauth2.client.registration.naver.client-id}")
  private String clientId;

  @Value("${spring.security.oauth2.client.registration.naver.redirect-uri}")
  private String redirectUri;

  @Value("${spring.security.oauth2.client.registration.naver.authorization-response-type}")
  private String authorizationResponseType;

  @Value("${spring.security.oauth2.client.registration.naver.client-secret}")
  private String clientSecret;

  @Value("${spring.security.oauth2.client.provider.naver.authorization-uri}")
  private String authorizationUri;

  @Value("${spring.security.oauth2.client.registration.naver.scope}")
  private String[] scope;

  @Override
  public OAuth2ProviderValues client() {
    return OAuth2ProviderValues.builder()
        .registration(Registration.builder()
            .provider(provider)
            .clientId(clientId)
            .redirectUri(redirectUri)
            .authorizationResponseType(authorizationResponseType)
            .clientSecret(clientSecret)
            .scope(Arrays.stream(scope).toList())
            .build())
        .provider(Provider.builder()
            .authorizationUri(authorizationUri)
            .build())
        .build();
  }
}
