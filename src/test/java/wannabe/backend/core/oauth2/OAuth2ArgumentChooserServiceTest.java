package wannabe.backend.core.oauth2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.naming.OperationNotSupportedException;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OAuth2ArgumentChooserServiceTest {

  @InjectMocks
  private OAuth2ArgumentChooserService chooser;

  @Mock
  private OAuth2ArgumentPort kakaoArgumentPort;

  @Test
  void 잘_선택되는지_확인() throws OperationNotSupportedException {
    // given
    // when
    val kakao = chooser.choose("kakao");
    // then
    assertThat(kakao).isEqualTo(kakaoArgumentPort);
  }

  @Test
  void 지정된거_아니면_NotS() {
    // given
    // when
    // then
    assertThrows(OperationNotSupportedException.class, () -> chooser.choose("naver"));
  }
}