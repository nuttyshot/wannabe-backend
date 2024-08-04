package wannabe.backend.idol.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import lombok.val;
import org.junit.jupiter.api.Test;

class IdolMemberFactoryTest {

  @Test
  void id과_name_으로_생성() {
    // given
    // when
    val member = IdolMemberFactory.create(1L, "MEMBER_NAME", 2L);
    // then
    assertThat(member.id()).isEqualTo(new IdolMemberId(1L));
    assertThat(member.name()).isEqualTo(new IdolMemberName("MEMBER_NAME"));
    assertThat(member.groupId()).isEqualTo(new IdolGroupId(2L));
  }

  @Test
  void name과_groupId로_생성() {
    // given
    // when
    val member = IdolMemberFactory.create("MEMBER_NAME", new IdolGroupId(1L));
    // then
    assertThat(member.id()).isNull();
    assertThat(member.name()).isEqualTo(new IdolMemberName("MEMBER_NAME"));
    assertThat(member.groupId()).isEqualTo(new IdolGroupId(1L));
  }
}