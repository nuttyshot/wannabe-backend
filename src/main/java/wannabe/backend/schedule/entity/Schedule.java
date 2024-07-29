package wannabe.backend.schedule.entity;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.NonNull;

@Builder
public record Schedule(ScheduleId id,
                       @NonNull String name,
                       @NonNull LocalDateTime dateTime) {

}
