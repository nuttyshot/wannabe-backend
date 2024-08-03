package wannabe.backend.infrastructure.schedule;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import lombok.val;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import wannabe.backend.schedule.entity.Schedule;
import wannabe.backend.schedule.entity.ScheduleId;

@DataJpaTest
class AddScheduleDataMapperTest {

  private AddScheduleDataMapper mapper;

  @Autowired
  private JpaScheduleRepository repository;

  @BeforeEach
  void setUp() {
    mapper = new AddScheduleDataMapper(repository);
  }

  @Test
  void 스케쥴_insert() {
    // given
    // when
    val scheduleId = mapper.addSchedule(Schedule.builder()
        .name("MOCK_SCHEDULE_NAME")
        .dateTime(LocalDateTime.MIN)
        .build());
    val schedule = repository.findById(scheduleId.value()).get();
    // then
    assertThat(schedule).isNotNull();
    assertThat(schedule.getName()).isEqualTo("MOCK_SCHEDULE_NAME");
  }
}