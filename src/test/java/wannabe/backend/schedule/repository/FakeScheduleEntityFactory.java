package wannabe.backend.schedule.repository;

import java.time.LocalDateTime;

public class FakeScheduleEntityFactory {

  public static ScheduleEntity create() {
    return ScheduleEntity.builder()
        .name("MOCK_SCHEDULE_NAME")
        .dateTime(LocalDateTime.MIN)
        .build();
  }
}
