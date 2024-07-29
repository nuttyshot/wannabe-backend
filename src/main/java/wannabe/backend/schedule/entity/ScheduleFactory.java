package wannabe.backend.schedule.entity;

import lombok.NonNull;
import wannabe.backend.schedule.usecase.addschedule.AddScheduleRequest;

public class ScheduleFactory {

  public static Schedule create(@NonNull AddScheduleRequest request) {
    return Schedule.builder()
        .name(request.name())
        .dateTime(request.dateTime())
        .build();
  }
}
