package wannabe.backend.idol.interactor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import wannabe.backend.idol.domain.IdolGroup;
import wannabe.backend.idol.usecase.AddIdolGroupUseCase;

@ExtendWith(MockitoExtension.class)
class AddDefaultAllIdolMembersInteractorTest {

  @InjectMocks
  private AddDefaultAllIdolMembersInteractor interactor;

  @Mock
  private AddIdolGroupUseCase addIdolGroupUseCase;

  @Test
  void 디폴트_그룹은_뉴진스다() {
    // given
    // when
    interactor.execute();
    // then
    val captor = ArgumentCaptor.forClass(IdolGroup.class);
    verify(addIdolGroupUseCase, only()).execute(captor.capture());
    assertThat(captor.getValue().name().value()).isEqualTo("NewJeans");
  }
}