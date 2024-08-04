package wannabe.backend.idol.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.val;
import org.junit.jupiter.api.Test;
import wannabe.backend.idol.domain.FakeIdolGroupFactory;

class IdolGroupMapperTest {

  @Test
  void IdolGroupEntity로_변환() {
    // given
    // when
    val entity = IdolGroupMapper.toEntity(FakeIdolGroupFactory.create("GROUP_NAME"));
    // then
    assertThat(entity.getName()).isEqualTo("GROUP_NAME");
  }
}