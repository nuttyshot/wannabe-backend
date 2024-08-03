package wannabe.backend.schedule.mapper;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import wannabe.backend.product.dto.AddProductRequest.Schedule;
import wannabe.backend.schedule.domain.ScheduleId;
import wannabe.backend.schedule.gateway.FindScheduleGateway;

@Service
public class FindScheduleDataMapper implements FindScheduleGateway {

  @Override
  public Schedule findById(@NonNull ScheduleId id) {
    return null;
  }
}
