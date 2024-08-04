package wannabe.backend.idol.interactor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import wannabe.backend.idol.domain.FakeIdolGroupFactory;
import wannabe.backend.idol.domain.IdolGroupId;
import wannabe.backend.idol.gateway.AddIdolGroupDsGateway;

@ExtendWith(MockitoExtension.class)
class  AddIdolGroupInteractorTest {

  @InjectMocks
  private AddIdolGroupInteractor interactor;

  @Mock
  private AddIdolGroupDsGateway gateway;

  @Test
  void 아이돌_그룹_추가() {
    // given
    when(gateway.save(any())).thenReturn(mock(IdolGroupId.class));
    // when
    val groupId = interactor.execute(FakeIdolGroupFactory.create());
    // then
    verify(gateway).save(any());

    assertThat(groupId).isInstanceOf(IdolGroupId.class);
  }
}