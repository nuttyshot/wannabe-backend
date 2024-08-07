package wannabe.backend.schedule.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import wannabe.backend.schedule.domain.FakeScheduleFactory;
import wannabe.backend.schedule.repository.ScheduleRepository;

@DataJpaTest
class AddScheduleDataMapperTest {

  private AddScheduleDataMapper mapper;

  @Autowired
  private ScheduleRepository repository;

  @BeforeEach
  void setUp() {
    mapper = new AddScheduleDataMapper(repository);
  }

  @Test
  void 스케쥴_insert() {
    // given
    // when
    val scheduleId = mapper.save(FakeScheduleFactory.create("SCHEDULE_NAME", LocalDateTime.MIN));
    val schedule = repository.findById(scheduleId.value()).get();
    // then
    assertThat(schedule).isNotNull();
    assertThat(schedule.getName()).isEqualTo("SCHEDULE_NAME");
  }
}