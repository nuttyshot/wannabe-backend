package wannabe.backend.token.usecase;

import lombok.NonNull;
import wannabe.backend.token.domain.TokenInformation;

public interface CreateAccessTokenUseCase {

  String execute(@NonNull TokenInformation tokenInformation, @NonNull String issuer);
}
