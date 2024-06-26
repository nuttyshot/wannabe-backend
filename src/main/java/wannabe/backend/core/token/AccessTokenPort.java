package wannabe.backend.core.token;

import lombok.NonNull;

public interface AccessTokenPort {

  String getAccessToken(@NonNull TokenInformation tokenInformation, @NonNull String issuer);
}
