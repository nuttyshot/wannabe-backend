package wannabe.backend.token.usecase;

import lombok.NonNull;
import wannabe.backend.token.domain.TokenInformation;

public interface CreateRefreshTokenUseCase {

  String getRefreshToken(@NonNull TokenInformation tokenInformation, @NonNull String issuer);
}
