package wannabe.backend.schedule.usecase.findschedule;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wannabe.backend.product.usecase.addproduct.ProductAddRequest.Schedule;
import wannabe.backend.schedule.entity.ScheduleId;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FindScheduleInteractor implements FindScheduleUseCase {

  private final FindScheduleGateway gateway;

  @Override
  public Schedule execute(@NonNull ScheduleId id) {
    return gateway.findById(id);
  }
}
