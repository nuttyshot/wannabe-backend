package wannabe.backend.schedule.interactor;

import java.util.NoSuchElementException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wannabe.backend.schedule.domain.Schedule;
import wannabe.backend.schedule.domain.ScheduleId;
import wannabe.backend.schedule.gateway.FindScheduleGateway;
import wannabe.backend.schedule.usecase.FindScheduleUseCase;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FindScheduleInteractor implements FindScheduleUseCase {

  private final FindScheduleGateway gateway;

  @Override
  public Schedule execute(@NonNull ScheduleId id) throws NoSuchElementException {
    return gateway.findById(id)
        .orElseThrow(() -> new NoSuchElementException("스케줄을 찾을 수 없습니다 : " + id));
  }
}
