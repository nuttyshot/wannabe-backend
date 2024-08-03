package wannabe.backend.token.interactor;

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
import wannabe.backend.token.configuration.ApiUrlArgumentGateway;
import wannabe.backend.token.domain.TokenInformation;
import wannabe.backend.token.usecase.CreateAccessTokenUseCase;
import wannabe.backend.token.usecase.CreateRefreshTokenUseCase;
import wannabe.backend.util.date.DateTimeProvider;

@ExtendWith(MockitoExtension.class)
class CreateLoginTokenInteratorTest {

  @InjectMocks
  private CreateLoginTokenInterator interator;

  @Mock
  private ApiUrlArgumentGateway apiUrlArgumentGateway;

  @Mock
  private CreateAccessTokenUseCase createAccessTokenUseCase;

  @Mock
  private CreateRefreshTokenUseCase createRefreshTokenUseCase;

  @Mock
  private DateTimeProvider dateTimeProvider;

  @Test
  void 로그인_토큰을_생성한다() {
    // given
    val NOW = Instant.now().getEpochSecond();
    val API_URL = "MOCK_API_URL";

    when(dateTimeProvider.nowTimestamp()).thenReturn(NOW);
    when(apiUrlArgumentGateway.getApiUrl()).thenReturn(API_URL);
    when(createAccessTokenUseCase.execute(any(), anyString())).thenReturn("MOCK_ACCESS_TOKEN");
    when(createRefreshTokenUseCase.getRefreshToken(any(), anyString())).thenReturn("MOCK_REFRESH_TOKEN");
    // when
    val loginToken = interator.execute(new TokenInformation(1L));
    // then
    assertThat(loginToken).isNotNull();

    verify(dateTimeProvider, only()).nowTimestamp();
    verify(apiUrlArgumentGateway, only()).getApiUrl();
    verify(createAccessTokenUseCase, only()).execute(any(), eq(API_URL + "/auth/login"));
    verify(createRefreshTokenUseCase, only()).getRefreshToken(any(), eq(API_URL + "/auth/login"));
  }
}