package wannabe.backend.init.interactor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import wannabe.backend.idol.usecase.AddIdolGroupUseCase;

@ExtendWith(MockitoExtension.class)
class InitInteractorTest {

  @InjectMocks
  private InitInteractor interactor;

  @Mock
  private AddIdolGroupUseCase useCase;

  @Test
  void 아이돌_그룹_추가() {
    // given
    // when
    interactor.execute();
    // then
    verify(useCase, only()).execute(any());
  }
}