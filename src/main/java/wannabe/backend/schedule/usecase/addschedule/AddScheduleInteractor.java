package wannabe.backend.schedule.usecase.addschedule;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wannabe.backend.schedule.entity.ScheduleFactory;
import wannabe.backend.schedule.entity.ScheduleId;

@Service
@Transactional
@RequiredArgsConstructor
public class AddScheduleInteractor implements AddScheduleUseCase {

  private final AddScheduleDsGateway gateway;

  @Override
  public ScheduleId addSchedule(@NonNull AddScheduleRequest request) {
    return gateway.addSchedule(ScheduleFactory.create(request));
  }
}
