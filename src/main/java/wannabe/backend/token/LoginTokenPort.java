package wannabe.backend.token;

import lombok.NonNull;

public interface LoginTokenPort {

  LoginToken getLoginToken(@NonNull TokenInformation tokenInformation);
}
