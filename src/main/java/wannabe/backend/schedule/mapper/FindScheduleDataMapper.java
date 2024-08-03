package wannabe.backend.schedule.mapper;

import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wannabe.backend.schedule.domain.Schedule;
import wannabe.backend.schedule.domain.ScheduleId;
import wannabe.backend.schedule.gateway.FindScheduleGateway;
import wannabe.backend.schedule.repository.ScheduleRepository;

@Service
@RequiredArgsConstructor
public class FindScheduleDataMapper implements FindScheduleGateway {

  private final ScheduleRepository repository;

  @Override
  public Optional<Schedule> findById(@NonNull ScheduleId id) {
    return repository.findById(id.value())
        .map(ScheduleMapper::toDomain);
  }
}
