package wannabe.backend.schedule.repository;

import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record FakeScheduleEntity(Long id, String name, LocalDateTime dateTime) {

  public ScheduleEntity create() {
    return ScheduleEntity.builder()
        .id(id)
        .name(name)
        .dateTime(dateTime)
        .build();
  }
}
