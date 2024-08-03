package wannabe.backend.idol.mapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import wannabe.backend.idol.domain.IdolMemberId;
import wannabe.backend.idol.repository.FakeIdolGroupEntityFactory;
import wannabe.backend.idol.repository.FakeIdolMemberEntityFactory;
import wannabe.backend.idol.repository.IdolGroupEntity;
import wannabe.backend.idol.repository.IdolGroupRepository;
import wannabe.backend.idol.repository.IdolMemberEntity;
import wannabe.backend.idol.repository.IdolMemberRepository;

@DataJpaTest
@ActiveProfiles("local")
class FindIdolMemberDataMapperTest {

  private FindIdolMemberDataMapper mapper;

  @Autowired
  private IdolMemberRepository idolMemberRepository;

  @Autowired
  private IdolGroupRepository idolGroupRepository;

  @BeforeEach
  void setUp() {
    mapper = new FindIdolMemberDataMapper(idolMemberRepository);
  }

  @Test
  void name_으로_IdolMember_찾기() {
    // given
    val group = idolGroupRepository.save(FakeIdolGroupEntityFactory.create());
    val member = idolMemberRepository.save(FakeIdolMemberEntityFactory.create(group));
    // when
    val findMember = mapper.findByName(member.getName()).get();
    // then
    assertThat(findMember.name().value()).isEqualTo("MOCK_NAME");
  }

  @Test
  void id로_IdolMember_찾기() {
    // given
    val group = idolGroupRepository.save(FakeIdolGroupEntityFactory.create());
    val member = idolMemberRepository.save(FakeIdolMemberEntityFactory.create(group));
    // when
    val findMember = mapper.findById(new IdolMemberId(member.getId())).get();
    // then
    assertThat(findMember.id().value()).isEqualTo(member.getId());
  }
}