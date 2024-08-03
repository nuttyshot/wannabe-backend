package wannabe.backend.schedule.usecase;

import java.util.NoSuchElementException;
import lombok.NonNull;
import wannabe.backend.schedule.domain.Schedule;
import wannabe.backend.schedule.domain.ScheduleId;

public interface FindScheduleUseCase {

  Schedule execute(@NonNull ScheduleId id) throws NoSuchElementException;
}
