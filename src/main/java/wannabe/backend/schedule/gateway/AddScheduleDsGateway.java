package wannabe.backend.schedule.gateway;

import lombok.NonNull;
import wannabe.backend.schedule.domain.Schedule;
import wannabe.backend.schedule.domain.ScheduleId;

public interface AddScheduleDsGateway {

  ScheduleId addSchedule(@NonNull Schedule schedule);
}
