package wannabe.backend.schedule.gateway;

import java.util.Optional;
import lombok.NonNull;
import wannabe.backend.schedule.domain.Schedule;
import wannabe.backend.schedule.domain.ScheduleId;

public interface FindScheduleGateway {

  Optional<Schedule> findById(@NonNull ScheduleId id);
}
