package wannabe.backend.token;

import lombok.NonNull;

public interface RefreshTokenPort {

  String getRefreshToken(@NonNull TokenInformation tokenInformation, @NonNull String issuer);
}
