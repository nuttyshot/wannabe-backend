package wannabe.backend.schedule.domain;

import static lombok.AccessLevel.PACKAGE;

import lombok.Builder;
import lombok.NonNull;

@Builder(access = PACKAGE)
public record Schedule(ScheduleId id,
                       @NonNull ScheduleName name,
                       @NonNull ScheduleDateTime dateTime) {

}
