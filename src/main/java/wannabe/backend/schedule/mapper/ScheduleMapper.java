package wannabe.backend.schedule.mapper;

import lombok.NonNull;
import wannabe.backend.schedule.domain.Schedule;
import wannabe.backend.schedule.domain.ScheduleFactory;
import wannabe.backend.schedule.repository.ScheduleEntity;

public class ScheduleMapper {

  private ScheduleMapper() {
  }

  public static ScheduleEntity toEntity(@NonNull Schedule schedule) {
    return ScheduleEntity.builder()
        .name(schedule.name().value())
        .dateTime(schedule.dateTime().value())
        .build();
  }

  public static Schedule toDomain(@NonNull ScheduleEntity entity) {
    return ScheduleFactory.create(entity.getId(), entity.getName(), entity.getDateTime());
  }
}
