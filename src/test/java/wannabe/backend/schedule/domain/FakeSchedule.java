package wannabe.backend.schedule.domain;

import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record FakeSchedule(long id, String name, LocalDateTime dateTime) {

  public Schedule create() {
    return Schedule.builder()
        .id(new ScheduleId(1L))
        .name(new ScheduleName("SCHEDULE_NAME"))
        .dateTime(new ScheduleDateTime(LocalDateTime.MIN))
        .build();
  }
}
