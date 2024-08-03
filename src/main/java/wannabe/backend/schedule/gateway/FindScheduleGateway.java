package wannabe.backend.schedule.gateway;

import lombok.NonNull;
import wannabe.backend.product.dto.AddProductRequest.Schedule;
import wannabe.backend.schedule.domain.ScheduleId;

public interface FindScheduleGateway {

  Schedule findById(@NonNull ScheduleId id);
}
