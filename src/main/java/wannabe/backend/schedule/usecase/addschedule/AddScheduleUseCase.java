package wannabe.backend.schedule.usecase.addschedule;

import wannabe.backend.schedule.entity.ScheduleId;

public interface AddScheduleUseCase {

  ScheduleId addSchedule(AddScheduleRequest request);
}
