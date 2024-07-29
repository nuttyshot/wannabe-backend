package wannabe.backend.member.findmember;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lombok.val;
import org.junit.jupiter.api.Test;
import wannabe.backend.member.usecase.findmember.AgeRange;

class AgeRangeTest {

  @Test
  void null이면_null로_반환한다() {
    // given
    // when
    val ageRange = AgeRange.fromKakaoString(null);
    // then
    assertThat(ageRange).isNull();
  }

  @Test
  void null이_아니면_해당하는_enum을_반환한다() {
    // given
    // when
    val ageRange = AgeRange.fromKakaoString("20~29");
    // then
    assertThat(ageRange).isEqualTo(AgeRange.TWENTIES);
  }

  @Test
  void 유효하지_않는_문자열이_들어오면_IllegalArgumentException이_발생된다() {
    // given
    // when
    // then
    assertThrows(IllegalArgumentException.class,
        () -> AgeRange.fromKakaoString("90~99"));
  }
}