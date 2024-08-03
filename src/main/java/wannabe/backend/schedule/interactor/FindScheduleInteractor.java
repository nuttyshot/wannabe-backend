package wannabe.backend.schedule.interactor;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wannabe.backend.product.dto.AddProductRequest.Schedule;
import wannabe.backend.schedule.domain.ScheduleId;
import wannabe.backend.schedule.gateway.FindScheduleGateway;
import wannabe.backend.schedule.usecase.FindScheduleUseCase;

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
