package wannabe.backend.schedule.mapper;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import wannabe.backend.schedule.repository.ScheduleEntity;
import wannabe.backend.schedule.repository.ScheduleRepository;
import wannabe.backend.schedule.domain.Schedule;
import wannabe.backend.schedule.domain.ScheduleId;
import wannabe.backend.schedule.gateway.AddScheduleDsGateway;

@Service
@RequiredArgsConstructor
public class AddScheduleDataMapper implements AddScheduleDsGateway {

  private final ScheduleRepository repository;

  @Override
  public ScheduleId addSchedule(@NonNull Schedule schedule) {
    val savedSchedule = repository.save(ScheduleEntity.builder()
        .name(schedule.name())
        .dateTime(schedule.dateTime())
        .build());
    return new ScheduleId(savedSchedule.getId());
  }
}
