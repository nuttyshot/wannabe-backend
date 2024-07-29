package wannabe.backend.member.usecase.oauth2integration.port;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static wannabe.backend.member.usecase.oauth2integration.Provider.KAKAO;
import static wannabe.backend.member.usecase.oauth2integration.Provider.NAVER;

import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import wannabe.backend.member.usecase.oauth2integration.port.OAuth2NetworkException;
import wannabe.backend.member.usecase.oauth2integration.port.OAuthErrorInteractor;

@ExtendWith(MockitoExtension.class)
class OAuthErrorInteractorTest {

  @InjectMocks
  private OAuthErrorInteractor interactor;

  @Test
  void status_200일때_Exception이_없어야한다() {
    // given
    // when
    // then
    assertDoesNotThrow(() -> interactor.receive(KAKAO, 200, Map.of()));
  }

  @Test
  void 카카오_4xx일때_OAuth2NetworkException이_발생해야한다() {
    // given
    // when
    // then
    assertThrowsExactly(OAuth2NetworkException.class,
        () -> interactor.receive(KAKAO, 400, Map.of()));
  }

  @Test
  void 네이버_4xx일때_OAuth2NetworkException이_발생해야한다() {
    // given
    // when
    // then
    assertThrowsExactly(OAuth2NetworkException.class,
        () -> interactor.receive(NAVER, 400, Map.of()));
  }
}