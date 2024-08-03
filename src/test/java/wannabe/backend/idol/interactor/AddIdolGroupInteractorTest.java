package wannabe.backend.idol.interactor;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import wannabe.backend.idol.domain.FakeIdolGroupFactory;
import wannabe.backend.idol.gateway.AddIdolGroupDsGateway;

@ExtendWith(MockitoExtension.class)
class AddIdolGroupInteractorTest {

  @InjectMocks
  private AddIdolGroupInteractor interactor;

  @Mock
  private AddIdolGroupDsGateway gateway;

  @Test
  void 아이돌_그룹_추가() {
    // given
    // when
    interactor.execute(FakeIdolGroupFactory.create());
    // then
    verify(gateway).save(any());
  }
}