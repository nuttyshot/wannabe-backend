package wannabe.backend.schedule.usecase.addschedule;

import lombok.NonNull;
import wannabe.backend.schedule.entity.ScheduleId;

public interface AddScheduleUseCase {

  ScheduleId addSchedule(@NonNull AddScheduleRequest request);
}
