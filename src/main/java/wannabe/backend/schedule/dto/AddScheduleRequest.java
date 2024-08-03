package wannabe.backend.schedule.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.NonNull;

@Builder
public record AddScheduleRequest(@NonNull String name,
                                 @NonNull LocalDateTime dateTime) {

}
