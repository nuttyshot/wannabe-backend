package wannabe.backend.init.interactor;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import wannabe.backend.idol.domain.IdolGroupId;
import wannabe.backend.idol.usecase.AddIdolGroupUseCase;
import wannabe.backend.idol.usecase.AddIdolMemberUseCase;
import wannabe.backend.product.usecase.AddProductUseCase;
import wannabe.backend.schedule.usecase.AddScheduleUseCase;

@ExtendWith(MockitoExtension.class)
class InitInteractorTest {

  @InjectMocks
  private InitInteractor interactor;

  @Mock
  private AddIdolGroupUseCase addIdolGroupUseCase;

  @Mock
  private AddIdolMemberUseCase addIdolMemberUseCase;

  @Mock
  private AddScheduleUseCase addScheduleUseCase;

  @Mock
  private AddProductUseCase addProductUseCase;

  @Test
  void 뉴진스_그룹_멤버_추가() {
    // given
    when(addIdolGroupUseCase.execute(any())).thenReturn(mock(IdolGroupId.class));
    // when
    interactor.execute();
    // then
    verify(addIdolGroupUseCase, only()).execute(any());
    verify(addIdolMemberUseCase, times(5)).execute(any());
  }
}