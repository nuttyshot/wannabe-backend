package wannabe.backend.idol.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.val;
import org.junit.jupiter.api.Test;

class IdolGroupFactoryTest {

  @Test
  void IdolGroup_생성() {
    // given
    // when
    val group = IdolGroupFactory.create("GROUP_NAME");
    // then
    assertThat(group.name().value()).isEqualTo("GROUP_NAME");
  }
}