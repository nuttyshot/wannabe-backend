package wannabe.backend.core.finduser;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import wannabe.backend.core.member.FakeMember;
import wannabe.backend.core.member.Member;
import wannabe.backend.core.member.MemberRepository;

@DataJpaTest
class FindMemberInteractorTest {

  private FindMemberInteractor interactor;

  @Autowired
  private MemberRepository memberRepository;

  @BeforeEach
  void setUp() {
    interactor = new FindMemberInteractor(memberRepository);
  }

  @Test
  void 이메일로_회원_찾기() {
    // given
    memberRepository.save(member());
    // when
    val findMember = interactor.findByEmail("MOCK_EMAIL").get();
    // then
    assertThat(findMember).isNotNull();
  }

  private static Member member() {
    return FakeMember.builder().email("MOCK_EMAIL").build().toMember();
  }
}