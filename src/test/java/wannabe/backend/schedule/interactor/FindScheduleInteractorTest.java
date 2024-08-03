package wannabe.backend.schedule.interactor;

import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.NoSuchElementException;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import wannabe.backend.schedule.domain.FakeScheduleFactory;
import wannabe.backend.schedule.domain.ScheduleId;
import wannabe.backend.schedule.gateway.FindScheduleGateway;
import wannabe.backend.schedule.repository.FakeScheduleEntityFactory;

@ExtendWith(MockitoExtension.class)
class FindScheduleInteractorTest {

  @InjectMocks
  private FindScheduleInteractor interactor;

  @Mock
  private FindScheduleGateway gateway;

  @Test
  void 스케쥴_조회() {
    // given
    when(gateway.findById(any())).thenReturn(Optional.of(FakeScheduleFactory.create()));
    // when
    interactor.execute(new ScheduleId(1L));
    // then
    verify(gateway, only()).findById(any());
  }

  @Test
  void 조회된_스케쥴이_없으면_NoSuchElementException_발생() {
    // given
    when(gateway.findById(any())).thenReturn(Optional.empty());
    // when
    // then
    assertThrowsExactly(NoSuchElementException.class, () -> interactor.execute(new ScheduleId(1L)));
  }
}