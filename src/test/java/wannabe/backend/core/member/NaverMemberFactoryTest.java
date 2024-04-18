package wannabe.backend.core.member;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import wannabe.backend.core.finduser.AgeRange;
import wannabe.backend.core.oauth2.Provider;
import wannabe.backend.core.oauth2.adapter.OAuth2Member;

@ExtendWith(MockitoExtension.class)
class NaverMemberFactoryTest {

  @InjectMocks
  private NaverMemberFactory factory;

  @Test
  void OAuth2Member를_Member로_변환한다() {
    // given
    // when
    val member = factory.create(OAuth2Member.builder()
        .provider(Provider.NAVER)
        .email("MOCK_EMAIL")
        .birthyear("2020")
        .ageRange("20-29")
        .build());
    // then
    assertThat(member.getBirthday()).isEqualTo(LocalDate.of(2020, 1, 1));
    assertThat(member.getAgeRange()).isEqualTo(AgeRange.TWENTIES);
  }
}