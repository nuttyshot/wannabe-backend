package wannabe.backend.token;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import wannabe.backend.util.date.DateTimeProvider;

@Service
@RequiredArgsConstructor
public class LoginTokenInterator implements LoginTokenPort {

  private final ApiUrlArgumentGateway apiUrlArgumentGateway;
  private final AccessTokenPort accessTokenPort;
  private final RefreshTokenPort refreshTokenPort;
  private final DateTimeProvider dateTimeProvider;

  @Override
  public LoginToken getLoginToken(@NonNull TokenInformation tokenInformation) {
    val now = dateTimeProvider.nowTimestamp();
    val accessTokenExpirationTime = 10 * 60 * 1000L; // 10분
    val issuer = apiUrlArgumentGateway.getApiUrl() + "/auth/login";

    val accessToken = accessTokenPort.getAccessToken(tokenInformation, issuer);
    val refreshToken = refreshTokenPort.getRefreshToken(tokenInformation, issuer);

    return LoginToken.builder()
        .accessToken(accessToken)
        .refreshToken(refreshToken)
        .expiredAt(now + accessTokenExpirationTime)
        .build();
  }
}
