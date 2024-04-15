package wannabe.backend.core.oauth2.adapter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OAuth2MemberFactoryTest {

  @InjectMocks
  private OAuth2MemberFactory factory;

  @Test
  void 카카오일때_provider_email_birthyear이_반환되어야한다() {
    // given
    val oauth2Response = Map.of("kakao_account",
        (Object) Map.of("email", "MOCK_EMAIL", "birthyear", "MOCK_BIRTHYEAR"));
    // when
    val oAuth2Member = factory.create("kakao", oauth2Response);
    // then
    assertThat(oAuth2Member.email()).isEqualTo("MOCK_EMAIL");
    assertThat(oAuth2Member.birthyear()).isEqualTo("MOCK_BIRTHYEAR");
  }
}