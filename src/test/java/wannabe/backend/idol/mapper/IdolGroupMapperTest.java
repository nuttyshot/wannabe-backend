package wannabe.backend.idol.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.val;
import org.junit.jupiter.api.Test;
import wannabe.backend.idol.domain.FakeIdolGroup;

class IdolGroupMapperTest {

  @Test
  void IdolGroupEntity로_변환() {
    // given
    // when
    val entity = IdolGroupMapper.toEntity(
        FakeIdolGroup.builder().name("GROUP_NAME").build().create());
    // then
    assertThat(entity.getName()).isEqualTo("GROUP_NAME");
  }
}