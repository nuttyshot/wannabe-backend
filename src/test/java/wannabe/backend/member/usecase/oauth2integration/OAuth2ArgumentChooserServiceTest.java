package wannabe.backend.member.usecase.oauth2integration;

import static org.assertj.core.api.Assertions.assertThat;
import static wannabe.backend.member.usecase.oauth2integration.Provider.KAKAO;
import static wannabe.backend.member.usecase.oauth2integration.Provider.NAVER;

import javax.naming.OperationNotSupportedException;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import wannabe.backend.member.usecase.oauth2integration.OAuth2ArgumentChooserService;
import wannabe.backend.member.usecase.oauth2integration.OAuth2ArgumentPort;

@SpringBootTest
@ActiveProfiles("local")
class OAuth2ArgumentChooserServiceTest {

  @Autowired
  private OAuth2ArgumentChooserService chooser;

  @Autowired
  private KakaoArgumentPort kakaoArgumentPort;

  @Autowired
  private NaverArgumentPort naverArgumentPort;

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