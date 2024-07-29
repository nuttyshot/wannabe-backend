package wannabe.backend.infrastructure.schedule;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import wannabe.backend.schedule.entity.Schedule;
import wannabe.backend.schedule.entity.ScheduleId;
import wannabe.backend.schedule.usecase.addschedule.AddScheduleDsGateway;

@Service
@RequiredArgsConstructor
public class AddScheduleDataMapper implements AddScheduleDsGateway {

  private final JpaScheduleRepository repository;

  @Override
  public ScheduleId addSchedule(@NonNull Schedule schedule) {
    val savedSchedule = repository.save(JpaSchedule.builder()
        .name(schedule.name())
        .dateTime(schedule.dateTime())
        .build());
    return new ScheduleId(savedSchedule.getId());
  }
}
