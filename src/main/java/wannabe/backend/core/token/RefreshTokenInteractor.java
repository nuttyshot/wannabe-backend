package wannabe.backend.core.token;

import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class RefreshTokenInteractor implements RefreshTokenPort {

  @Override
  public String getRefreshToken(@NonNull TokenInformation tokenInformation, @NonNull String issuer) {
    return "";
  }
}
