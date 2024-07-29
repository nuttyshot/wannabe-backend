package wannabe.backend.token.usecase.getlogintoken;

import lombok.NonNull;

public interface AccessTokenPort {

  String getAccessToken(@NonNull TokenInformation tokenInformation, @NonNull String issuer);
}
