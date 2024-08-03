package wannabe.backend.infrastructure.schedule;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import wannabe.backend.product.usecase.addproduct.ProductAddRequest.Schedule;
import wannabe.backend.schedule.entity.ScheduleId;
import wannabe.backend.schedule.usecase.findschedule.FindScheduleGateway;

@Service
public class FindScheduleDataMapper implements FindScheduleGateway {

  @Override
  public Schedule findById(@NonNull ScheduleId id) {
    return null;
  }
}
