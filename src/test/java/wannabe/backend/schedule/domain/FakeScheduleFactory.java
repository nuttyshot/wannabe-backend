package wannabe.backend.schedule.domain;

import java.time.LocalDateTime;

public class FakeScheduleFactory {

  public static Schedule create() {
    return Schedule.builder()
        .id(new ScheduleId(1))
        .name(new ScheduleName("SCHEDULE_NAME"))
        .dateTime(new ScheduleDateTime(LocalDateTime.MIN))
        .build();
  }

  public static Schedule create(String name, LocalDateTime dateTime) {
    return Schedule.builder()
        .name(new ScheduleName(name))
        .dateTime(new ScheduleDateTime(dateTime))
        .build();
  }
}
