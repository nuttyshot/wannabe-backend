package wannabe.backend.core.token;

import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class AccessTokenInteractor implements AccessTokenPort {

  @Override
  public String getAccessToken(@NonNull TokenInformation tokenInformation, @NonNull String issuer,
      @NonNull String uuid, int accessTokenExpirationTime) {
    return "";
  }
}
