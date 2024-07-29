package wannabe.backend.member.usecase.oauth2integration.adapter;

import static org.assertj.core.api.Assertions.assertThat;
import static wannabe.backend.member.usecase.oauth2integration.Provider.*;

import java.util.Map;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import wannabe.backend.member.usecase.oauth2integration.adapter.OAuth2MemberFactory;

@ExtendWith(MockitoExtension.class)
class OAuth2MemberFactoryTest {

  @InjectMocks
  private OAuth2MemberFactory factory;

  @Test
  void 카카오_응답_OAuth2Member_로_변환되어야한다() {
    // given
    val oauth2Response = Map.of("kakao_account",
        (Object) Map.of("email", "MOCK_EMAIL",
            "birthyear", "MOCK_BIRTHYEAR",
            "profile", Map.of("nickname", "MOCK_NICKNAME")));
    // when
    val oAuth2Member = factory.create(KAKAO, oauth2Response);
    // then
    assertThat(oAuth2Member.email()).isEqualTo("MOCK_EMAIL");
    assertThat(oAuth2Member.birthyear()).isEqualTo("MOCK_BIRTHYEAR");
    assertThat(oAuth2Member.nickname()).isEqualTo("MOCK_NICKNAME");
  }

  @Test
  void 네이버_응답_OAuth2Member_로_변환되어야한다() {
    // given
    val oauth2Response = Map.of("response",
        (Object) Map.of("email", "MOCK_EMAIL",
            "birthyear", "MOCK_BIRTHYEAR"));
    // when
    val oAuth2Member = factory.create(NAVER, oauth2Response);
    // then
    assertThat(oAuth2Member.email()).isEqualTo("MOCK_EMAIL");
    assertThat(oAuth2Member.birthyear()).isEqualTo("MOCK_BIRTHYEAR");
  }
}