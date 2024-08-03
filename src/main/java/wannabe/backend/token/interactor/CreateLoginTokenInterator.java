package wannabe.backend.token.interactor;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import wannabe.backend.token.usecase.CreateAccessTokenUseCase;
import wannabe.backend.token.usecase.CreateLoginTokenUseCase;
import wannabe.backend.token.configuration.ApiUrlArgumentGateway;
import wannabe.backend.token.domain.LoginToken;
import wannabe.backend.token.usecase.CreateRefreshTokenUseCase;
import wannabe.backend.token.domain.TokenInformation;
import wannabe.backend.util.date.DateTimeProvider;

@Service
@RequiredArgsConstructor
public class CreateLoginTokenInterator implements CreateLoginTokenUseCase {

  private final ApiUrlArgumentGateway apiUrlArgumentGateway;
  private final CreateAccessTokenUseCase createAccessTokenUseCase;
  private final CreateRefreshTokenUseCase createRefreshTokenUseCase;
  private final DateTimeProvider dateTimeProvider;

  @Override
  public LoginToken execute(@NonNull TokenInformation tokenInformation) {
    val now = dateTimeProvider.nowTimestamp();
    val accessTokenExpirationTime = 10 * 60 * 1000L; // 10분
    val issuer = apiUrlArgumentGateway.getApiUrl() + "/auth/login";

    val accessToken = createAccessTokenUseCase.execute(tokenInformation, issuer);
    val refreshToken = createRefreshTokenUseCase.getRefreshToken(tokenInformation, issuer);

    return LoginToken.builder()
        .accessToken(accessToken)
        .refreshToken(refreshToken)
        .expiredAt(now + accessTokenExpirationTime)
        .build();
  }
}
