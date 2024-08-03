package wannabe.backend.idol.interactor;

import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
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
import wannabe.backend.idol.domain.FakeIdolMemberFactory;
import wannabe.backend.idol.gateway.FindIdolMemberDsGateway;

@ExtendWith(MockitoExtension.class)
class FindIdolMemberByNameInteractorTest {

  @InjectMocks
  private FindIdolMemberByNameInteractor interactor;

  @Mock
  private FindIdolMemberDsGateway gateway;

  @Test
  void 아이돌_멤버_찾기() {
    // given
    when(gateway.findByName("MOCK_NAME")).thenReturn(Optional.of(FakeIdolMemberFactory.create()));
    // when
    interactor.execute("MOCK_NAME");
    // then
    verify(gateway, only()).findByName("MOCK_NAME");
  }

  @Test
  void 조회된_멤버_없으면_NoSuchElementException_발생() {
    // given
    when(gateway.findByName("MOCK_NAME")).thenReturn(Optional.empty());
    // when
    // then
    assertThrowsExactly(NoSuchElementException.class, () -> interactor.execute("MOCK_NAME"));
  }
}