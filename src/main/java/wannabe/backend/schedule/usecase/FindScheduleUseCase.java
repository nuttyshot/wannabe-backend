package wannabe.backend.schedule.usecase;

import lombok.NonNull;
import wannabe.backend.product.dto.AddProductRequest.Schedule;
import wannabe.backend.schedule.domain.ScheduleId;

public interface FindScheduleUseCase {

  Schedule execute(@NonNull ScheduleId id);
}
