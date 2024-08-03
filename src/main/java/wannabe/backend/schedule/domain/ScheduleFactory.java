package wannabe.backend.schedule.domain;

import java.time.LocalDateTime;
import lombok.NonNull;

public class ScheduleFactory {

  private ScheduleFactory() {
  }

  public static Schedule create(@NonNull Long id, @NonNull String name,
      @NonNull LocalDateTime dateTime) {

    return Schedule.builder()
        .id(new ScheduleId(id))
        .name(new ScheduleName(name))
        .dateTime(new ScheduleDateTime(dateTime))
        .build();
  }

  public static Schedule create(@NonNull String name,
      @NonNull LocalDateTime dateTime) {

    return Schedule.builder()
        .name(new ScheduleName(name))
        .dateTime(new ScheduleDateTime(dateTime))
        .build();
  }
}
