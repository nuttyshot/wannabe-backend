package wannabe.backend.schedule.usecase.findschedule;

import lombok.NonNull;
import wannabe.backend.product.usecase.addproduct.ProductAddRequest.Schedule;
import wannabe.backend.schedule.entity.ScheduleId;

public interface FindScheduleGateway {

  Schedule findById(@NonNull ScheduleId id);
}
