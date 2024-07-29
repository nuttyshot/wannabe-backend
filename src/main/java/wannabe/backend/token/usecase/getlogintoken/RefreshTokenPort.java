package wannabe.backend.token.usecase.getlogintoken;

import lombok.NonNull;

public interface RefreshTokenPort {

  String getRefreshToken(@NonNull TokenInformation tokenInformation, @NonNull String issuer);
}
