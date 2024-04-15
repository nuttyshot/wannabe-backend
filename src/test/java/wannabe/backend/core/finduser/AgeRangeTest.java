package wannabe.backend.core.finduser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lombok.val;
import org.junit.jupiter.api.Test;

class AgeRangeTest {

  @Test
  void null이면_null로_반환한다() {
    // given
    // when
    val ageRange = AgeRange.fromString(null);
    // then
    assertThat(ageRange).isNull();
  }

  @Test
  void null이_아니면_해당하는_enum을_반환한다() {
    // given
    // when
    val ageRange = AgeRange.fromString("20~29");
    // then
    assertThat(ageRange).isEqualTo(AgeRange.AGE_20_29);
  }

  @Test
  void 유효하지_않는_문자열이_들어오면_IllegalArgumentException이_발생된다() {
    // given
    // when
    // then
    assertThrows(IllegalArgumentException.class,
        () -> AgeRange.fromString("90~99"));
  }
}