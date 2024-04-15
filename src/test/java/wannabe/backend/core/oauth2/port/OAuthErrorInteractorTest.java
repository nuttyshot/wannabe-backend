package wannabe.backend.core.oauth2.port;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OAuthErrorInteractorTest {

  @InjectMocks
  private OAuthErrorInteractor interactor;

  @Test
  void 카카오_200일때_Exception이_없어야한다() {
    // given
    // when
    // then
    assertDoesNotThrow(() -> interactor.receive("kakao", 200, Map.of()));
  }

  @Test
  void 카카오_4xx일때_OAuth2NetworkException이_발생해야한다() {
    // given
    // when
    // then
    assertThrowsExactly(OAuth2NetworkException.class,
        () -> interactor.receive("kakao", 400, Map.of()));
  }

  @Test
  void provider를_지원하지_않는_경우_IllegalArgumentException이_발생해야한다() {
    // given
    // when
    // then
    assertThrowsExactly(IllegalArgumentException.class,
        () -> interactor.receive("naver", 400, Map.of()));
  }
}