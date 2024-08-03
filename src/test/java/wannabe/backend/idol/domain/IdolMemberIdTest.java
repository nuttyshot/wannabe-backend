package wannabe.backend.idol.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IdolMemberIdTest {

  @Test
  void id는_1_이상이어야_한다() {
    // given
    // when
    // then
    assertDoesNotThrow(() -> new IdolMemberId(1L));
  }

  @Test
  void id가_1_미만이면_IllegalArgumentException_발생() {
    // given
    // when
    // then
    assertThrowsExactly(IllegalArgumentException.class, () -> new IdolMemberId(0L));
  }
}