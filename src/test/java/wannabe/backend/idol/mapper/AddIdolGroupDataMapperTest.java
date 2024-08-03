package wannabe.backend.idol.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import wannabe.backend.idol.domain.FakeIdolGroupFactory;
import wannabe.backend.idol.repository.IdolGroupRepository;

@DataJpaTest
@ActiveProfiles("local")
class AddIdolGroupDataMapperTest {

  private AddIdolGroupDataMapper mapper;

  @Autowired
  private IdolGroupRepository repository;

  @BeforeEach
  void setUp() {
    mapper = new AddIdolGroupDataMapper(repository);
  }

  @Test
  void 아이돌_그룹_추가() {
    // given
    // when
    val group = mapper.save(FakeIdolGroupFactory.create());
    val findGroup = repository.findById(group.value()).get();
    // then
    assertThat(findGroup.getId()).isEqualTo(group.value());
  }
}