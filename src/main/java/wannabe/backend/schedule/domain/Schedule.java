package wannabe.backend.schedule.domain;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.NonNull;

@Builder
public record Schedule(ScheduleId id,
                       @NonNull String name,
                       @NonNull LocalDateTime dateTime) {

}
