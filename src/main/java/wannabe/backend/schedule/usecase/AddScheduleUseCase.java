package wannabe.backend.schedule.usecase;

import lombok.NonNull;
import wannabe.backend.schedule.domain.ScheduleId;
import wannabe.backend.schedule.dto.AddScheduleRequest;

public interface AddScheduleUseCase {

  ScheduleId execute(@NonNull AddScheduleRequest request);
}
