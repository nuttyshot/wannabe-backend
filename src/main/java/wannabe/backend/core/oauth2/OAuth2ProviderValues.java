package wannabe.backend.core.oauth2;

import java.util.List;
import lombok.Builder;

@Builder
public record OAuth2ProviderValues(
    Registration registration,
    Provider provider
) {

  @Builder
  public record Registration(
      String provider,
      String clientId,
      String redirectUri,
      String tokenGrantType,
      String authorizationResponseType,
      String clientSecret,
      List<String> scope
  ) {

  }

  @Builder
  public record Provider(
      String authorizationUri,
      String tokenUri
  ) {

  }
}
