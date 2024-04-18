package wannabe.backend.core.oauth2;

import static org.assertj.core.api.Assertions.assertThat;
import static wannabe.backend.core.oauth2.Provider.KAKAO;
import static wannabe.backend.core.oauth2.Provider.NAVER;

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

  @Mock
  private OAuth2ArgumentPort naverArgumentPort;

  @Test
  void kakao_잘_선택되는지_확인() throws OperationNotSupportedException {
    // given
    // when
    val kakao = chooser.choose(KAKAO);
    // then
    assertThat(kakao).isEqualTo(kakaoArgumentPort);
  }

  @Test
  void naver_잘_선택되는지_확인() throws OperationNotSupportedException {
    // given
    // when
    val naver = chooser.choose(NAVER);
    // then
    assertThat(naver).isEqualTo(naverArgumentPort);
  }
}