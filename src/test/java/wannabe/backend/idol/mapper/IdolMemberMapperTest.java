package wannabe.backend.idol.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.val;
import org.junit.jupiter.api.Test;
import wannabe.backend.idol.domain.FakeIdolMemberFactory;
import wannabe.backend.idol.repository.FakeIdolMemberEntityFactory;

class IdolMemberMapperTest {

  @Test
  void member도메인을_JPA_엔티티로_변환() {
    // given
    // when
    val entity = IdolMemberMapper.toEntity(FakeIdolMemberFactory.create());
    // then
    assertThat(entity.getName()).isEqualTo("MEMBER_NAME");
    assertThat(entity.getGroup().getId()).isEqualTo(2L);
  }

  @Test
  void JPA_엔티티를_member도메인으로_변환() {
    // given
    // when
    val domain = IdolMemberMapper.toDomain(FakeIdolMemberEntityFactory.create(1L, 2L));
    // then
    assertThat(domain.id().value()).isEqualTo(1L);
    assertThat(domain.name().value()).isEqualTo("MEMBER_NAME");
    assertThat(domain.groupId().value()).isEqualTo(2L);
  }
}