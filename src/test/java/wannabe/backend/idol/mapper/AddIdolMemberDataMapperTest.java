package wannabe.backend.idol.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import wannabe.backend.idol.domain.FakeIdolMemberFactory;
import wannabe.backend.idol.domain.IdolMemberId;
import wannabe.backend.idol.repository.FakeIdolGroupEntityFactory;
import wannabe.backend.idol.repository.IdolGroupEntity;
import wannabe.backend.idol.repository.IdolGroupRepository;
import wannabe.backend.idol.repository.IdolMemberEntity;
import wannabe.backend.idol.repository.IdolMemberRepository;

@DataJpaTest
@ActiveProfiles("local")
class AddIdolMemberDataMapperTest {

  private AddIdolMemberDataMapper mapper;

  @Autowired
  private IdolMemberRepository idolMemberRepository;

  @Autowired
  private IdolGroupRepository idolGroupRepository;

  @BeforeEach
  void setUp() {
    mapper = new AddIdolMemberDataMapper(idolMemberRepository);
  }

  @Test
  void 아이돌_멤버_추가() {
    // given
    val group = idolGroupRepository.save(
        FakeIdolGroupEntityFactory.create("GROUP_NAME"));
    // when
    val memberId = mapper.save(
        FakeIdolMemberFactory.create("MEMBER_NAME", group.getId()));
    val findMember = idolMemberRepository.findById(memberId.value()).get();
    // then
    assertThat(findMember.getGroup().getId()).isEqualTo(group.getId());
    assertThat(findMember.getName()).isEqualTo("MEMBER_NAME");
  }
}