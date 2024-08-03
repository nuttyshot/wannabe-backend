package wannabe.backend.schedule.domain.factory;

import lombok.NonNull;
import wannabe.backend.schedule.domain.Schedule;
import wannabe.backend.schedule.dto.AddScheduleRequest;

public class ScheduleFactory {

  public static Schedule create(@NonNull AddScheduleRequest request) {
    return Schedule.builder()
        .name(request.name())
        .dateTime(request.dateTime())
        .build();
  }
}
