package wannabe.backend.product.interactor;

import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
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
import wannabe.backend.idol.usecase.FindIdolMemberByIdUseCase;
import wannabe.backend.like.usecase.CheckProductLikeStatusUseCase;
import wannabe.backend.product.domain.FakeProductFactory;
import wannabe.backend.product.gateway.FindProductDsGateway;
import wannabe.backend.product.presenter.FindProductPresenter;
import wannabe.backend.schedule.usecase.FindScheduleUseCase;

@ExtendWith(MockitoExtension.class)
class FindProductInteractorTest {

  @InjectMocks
  private FindProductInteractor interactor;

  @Mock
  private FindProductDsGateway gateway;

  @Mock
  private FindProductPresenter presenter;

  @Mock
  private FindScheduleUseCase findScheduleUseCase;

  @Mock
  private FindIdolMemberByIdUseCase findIdolMemberByIdUseCase;

  @Mock
  private CheckProductLikeStatusUseCase checkProductLikeStatusUseCase;

  @Test
  void 상품_조회() {
    // given
    when(gateway.findById(anyLong())).thenReturn(Optional.of(FakeProductFactory.create()));
    // when
    interactor.findProduct(1L);
    // then
    verify(gateway, only()).findById(anyLong());
    verify(findScheduleUseCase, only()).execute(any());
    verify(findIdolMemberByIdUseCase, only()).execute(any());
    verify(checkProductLikeStatusUseCase, only()).execute(any());
    verify(presenter, only()).create(any(), any(), any(), any());
  }

  @Test
  void 조회된_상품이_없으면_NoSuchElementException_발생() {
    // given
    when(gateway.findById(anyLong())).thenReturn(Optional.empty());
    // when
    // then
    assertThrowsExactly(NoSuchElementException.class, () -> interactor.findProduct(1L));
  }
}