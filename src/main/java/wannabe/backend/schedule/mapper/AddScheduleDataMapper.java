package wannabe.backend.schedule.mapper;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import wannabe.backend.schedule.repository.JpaSchedule;
import wannabe.backend.schedule.repository.JpaScheduleRepository;
import wannabe.backend.schedule.domain.Schedule;
import wannabe.backend.schedule.domain.ScheduleId;
import wannabe.backend.schedule.gateway.AddScheduleDsGateway;

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
