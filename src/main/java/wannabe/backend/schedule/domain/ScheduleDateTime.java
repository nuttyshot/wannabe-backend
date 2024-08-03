package wannabe.backend.schedule.domain;

import java.time.LocalDateTime;
import lombok.NonNull;

public record ScheduleDateTime(@NonNull LocalDateTime value) {

}
