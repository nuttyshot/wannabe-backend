package wannabe.backend.token.usecase.getlogintoken;

import lombok.NonNull;

public interface LoginTokenPort {

  LoginToken getLoginToken(@NonNull TokenInformation tokenInformation);
}
