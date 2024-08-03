package wannabe.backend.member.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import lombok.val;
import org.junit.jupiter.api.Test;

class MemberIdTest {

  @Test
  void MemberId는_값이_있다면_1_이상_이어야_한다() {
    // given
    val value = 1L;
    // when
    // then
    assertDoesNotThrow(() -> new MemberId(value));
  }

  @Test
  void MemberId가_1_미만이면_IllegalArgumentException_발생() {
    // given
    val value = 0L;
    // when
    // then
    assertThrowsExactly(IllegalArgumentException.class, () -> new MemberId(value));
  }
}