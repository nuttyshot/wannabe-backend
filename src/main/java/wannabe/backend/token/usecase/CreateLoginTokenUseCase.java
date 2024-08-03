package wannabe.backend.token.usecase;

import lombok.NonNull;
import wannabe.backend.token.domain.LoginToken;
import wannabe.backend.token.domain.TokenInformation;

public interface CreateLoginTokenUseCase {

  LoginToken execute(@NonNull TokenInformation tokenInformation);
}
