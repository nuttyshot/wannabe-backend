package wannabe.backend.idol.usecase.findidolmemberbyid;

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
import wannabe.backend.idol.FakeIdolMemberFactory;
import wannabe.backend.idol.entity.IdolMember;
import wannabe.backend.idol.entity.IdolMemberId;
import wannabe.backend.idol.usecase.FindIdolMemberDsGateway;

@ExtendWith(MockitoExtension.class)
class FindIdolMemberByIdInteractorTest {

  @InjectMocks
  private FindIdolMemberByIdInteractor interactor;

  @Mock
  private FindIdolMemberDsGateway gateway;

  @Test
  void id로_아이돌_멤버_조회() {
    // given
    when(gateway.findById(any())).thenReturn(Optional.of(FakeIdolMemberFactory.create()));
    // when
    interactor.execute(new IdolMemberId(1L));
    // then
    verify(gateway, only()).findById(any());
  }

  @Test
  void 조회된_멤버가_없을_경우_NoSuchElementException_발생() {
    // given
    when(gateway.findById(any())).thenReturn(Optional.empty());
    // when
    // then
    assertThrowsExactly(NoSuchElementException.class,
        () -> interactor.execute(new IdolMemberId(1L)));
  }
}