package wannabe.backend.member.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import wannabe.backend.member.domain.AgeRange;
import wannabe.backend.member.domain.Provider;
import wannabe.backend.member.repository.JpaMember;
import wannabe.backend.member.repository.JpaMemberRepository;

@DataJpaTest
class FindMemberDataMapperTest {

  private FindMemberDataMapper mapper;

  @Autowired
  private JpaMemberRepository repository;

  @BeforeEach
  void setUp() {
    mapper = new FindMemberDataMapper(repository);
  }

  @Test
  void 이메일로_회원_찾기() {
    // given
    repository.save(member());
    // when
    val findMember = mapper.findByEmail("MOCK_EMAIL").get();
    // then
    assertThat(findMember).isNotNull();
  }

  private static JpaMember member() {
    return JpaMember.builder()
        .email("MOCK_EMAIL")
        .birthday(LocalDate.MIN)
        .nickname("MOCK_NICKNAME")
        .name("MOCK_NAME")
        .ageRange(AgeRange.FIFTIES)
        .provider(Provider.KAKAO)
        .build();
  }
}