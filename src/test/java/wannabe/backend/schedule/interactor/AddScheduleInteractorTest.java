package wannabe.backend.schedule.interactor;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import wannabe.backend.schedule.domain.Schedule;
import wannabe.backend.schedule.dto.AddScheduleRequest;
import wannabe.backend.schedule.gateway.AddScheduleDsGateway;

@ExtendWith(MockitoExtension.class)
class AddScheduleInteractorTest {

  @InjectMocks
  private AddScheduleInteractor interactor;

  @Mock
  private AddScheduleDsGateway gateway;

  @Test
  void 스케쥴_추가() {
    // given
    // when
    interactor.execute(request());
    // then
    verify(gateway, only()).addSchedule(any(Schedule.class));
  }

  private AddScheduleRequest request() {
    return AddScheduleRequest.builder()
        .name("MOCK_SCHEDULE_NAME")
        .dateTime(LocalDateTime.MIN)
        .build();
  }
}