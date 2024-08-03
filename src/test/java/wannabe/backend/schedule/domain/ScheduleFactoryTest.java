package wannabe.backend.schedule.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import lombok.val;
import org.junit.jupiter.api.Test;

class ScheduleFactoryTest {

  @Test
  void Schedule_생성_with_id_name_dateTime() {
    // given
    // when
    val schedule = ScheduleFactory.create(1L, "SCHEDULE_NAME", LocalDateTime.MIN);
    // then
    assertThat(schedule.id().value()).isEqualTo(1L);
    assertThat(schedule.name().value()).isEqualTo("SCHEDULE_NAME");
  }

  @Test
  void Schedule_생성_with_name_dateTime() {
    // given
    // when
    val schedule = ScheduleFactory.create("SCHEDULE_NAME", LocalDateTime.MIN);
    // then
    assertThat(schedule.id()).isNull();
    assertThat(schedule.name().value()).isEqualTo("SCHEDULE_NAME");
    assertThat(schedule.dateTime().value()).isEqualTo(LocalDateTime.MIN);
  }
}