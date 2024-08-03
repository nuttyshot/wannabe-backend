package wannabe.backend.schedule.usecase.findschedule;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import wannabe.backend.schedule.entity.ScheduleId;

@ExtendWith(MockitoExtension.class)
class FindScheduleInteractorTest {

  @InjectMocks
  private FindScheduleInteractor interactor;

  @Mock
  private FindScheduleGateway gateway;

  @Test
  void 스케쥴_조회() {
    // given
    // when
    interactor.execute(new ScheduleId(1L));
    // then
    verify(gateway, only()).findById(any());
  }
}