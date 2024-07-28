package wannabe.backend.core.token;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.Instant;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import wannabe.backend.token.AccessTokenPort;
import wannabe.backend.token.ApiUrlArgumentGateway;
import wannabe.backend.util.date.DateTimeProvider;
import wannabe.backend.token.LoginTokenInterator;
import wannabe.backend.token.RefreshTokenPort;
import wannabe.backend.token.TokenInformation;

@ExtendWith(MockitoExtension.class)
class LoginTokenInteratorTest {

  @InjectMocks
  private LoginTokenInterator interator;

  @Mock
  private ApiUrlArgumentGateway apiUrlArgumentGateway;

  @Mock
  private AccessTokenPort accessTokenPort;

  @Mock
  private RefreshTokenPort refreshTokenPort;

  @Mock
  private DateTimeProvider dateTimeProvider;

  @Test
  void 로그인_토큰을_생성한다() {
    // given
    val NOW = Instant.now().getEpochSecond();
    val API_URL = "MOCK_API_URL";

    when(dateTimeProvider.nowTimestamp()).thenReturn(NOW);
    when(apiUrlArgumentGateway.getApiUrl()).thenReturn(API_URL);
    when(accessTokenPort.getAccessToken(any(), anyString())).thenReturn("MOCK_ACCESS_TOKEN");
    when(refreshTokenPort.getRefreshToken(any(), anyString())).thenReturn("MOCK_REFRESH_TOKEN");
    // when
    val loginToken = interator.getLoginToken(new TokenInformation(1L));
    // then
    assertThat(loginToken).isNotNull();

    verify(dateTimeProvider, only()).nowTimestamp();
    verify(apiUrlArgumentGateway, only()).getApiUrl();
    verify(accessTokenPort, only()).getAccessToken(any(), eq(API_URL + "/auth/login"));
    verify(refreshTokenPort, only()).getRefreshToken(any(), eq(API_URL + "/auth/login"));
  }
}