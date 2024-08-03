package wannabe.backend.member.interactor;

import static org.assertj.core.api.Assertions.assertThat;
import static wannabe.backend.member.domain.Provider.KAKAO;
import static wannabe.backend.member.domain.Provider.NAVER;

import javax.naming.OperationNotSupportedException;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import wannabe.backend.oauth2.configuration.KakaoArgument;
import wannabe.backend.oauth2.configuration.NaverArgument;
import wannabe.backend.oauth2.interactor.OAuth2ArgumentChooserService;

@SpringBootTest
@ActiveProfiles("local")
class OAuth2ArgumentChooserServiceTest {

  @Autowired
  private OAuth2ArgumentChooserService chooser;

  @Autowired
  private KakaoArgument kakaoArgument;

  @Autowired
  private NaverArgument naverArgument;

  @Test
  void kakao_잘_선택되는지_확인() throws OperationNotSupportedException {
    // given
    // when
    val kakao = chooser.choose(KAKAO);
    // then
    assertThat(kakao).isEqualTo(kakaoArgument);
  }

  @Test
  void naver_잘_선택되는지_확인() throws OperationNotSupportedException {
    // given
    // when
    val naver = chooser.choose(NAVER);
    // then
    assertThat(naver).isEqualTo(naverArgument);
  }
}