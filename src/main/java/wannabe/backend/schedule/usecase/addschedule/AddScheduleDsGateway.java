package wannabe.backend.schedule.usecase.addschedule;

import lombok.NonNull;
import wannabe.backend.schedule.entity.Schedule;
import wannabe.backend.schedule.entity.ScheduleId;

public interface AddScheduleDsGateway {

  ScheduleId addSchedule(@NonNull Schedule schedule);
}
