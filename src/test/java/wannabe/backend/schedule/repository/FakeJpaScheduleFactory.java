package wannabe.backend.schedule.repository;

import java.time.LocalDateTime;

public class FakeJpaScheduleFactory {

  public static JpaSchedule create() {
    return JpaSchedule.builder()
        .name("MOCK_SCHEDULE_NAME")
        .dateTime(LocalDateTime.MIN)
        .build();
  }
}
