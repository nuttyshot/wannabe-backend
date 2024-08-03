package wannabe.backend.schedule.interactor;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wannabe.backend.schedule.domain.factory.ScheduleFactory;
import wannabe.backend.schedule.domain.ScheduleId;
import wannabe.backend.schedule.gateway.AddScheduleDsGateway;
import wannabe.backend.schedule.dto.AddScheduleRequest;
import wannabe.backend.schedule.usecase.AddScheduleUseCase;

@Service
@Transactional
@RequiredArgsConstructor
public class AddScheduleInteractor implements AddScheduleUseCase {

  private final AddScheduleDsGateway gateway;

  @Override
  public ScheduleId execute(@NonNull AddScheduleRequest request) {
    return gateway.addSchedule(ScheduleFactory.create(request));
  }
}
