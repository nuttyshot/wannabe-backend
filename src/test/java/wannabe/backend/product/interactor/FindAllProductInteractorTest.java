package wannabe.backend.product.interactor;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import wannabe.backend.idol.usecase.FindIdolMemberByIdUseCase;
import wannabe.backend.product.domain.FakeProductFactory;
import wannabe.backend.product.domain.Products;
import wannabe.backend.product.gateway.FindAllProductDsGateway;
import wannabe.backend.product.presenter.ProductResponsePresenter;
import wannabe.backend.schedule.usecase.FindScheduleUseCase;

@ExtendWith(MockitoExtension.class)
class FindAllProductInteractorTest {

  @InjectMocks
  private FindAllProductInteractor interactor;

  @Mock
  private FindAllProductDsGateway findAllProductDsGateway;

  @Mock
  private FindScheduleUseCase findScheduleUseCase;

  @Mock
  private FindIdolMemberByIdUseCase findIdolMemberByIdUseCase;

  @Mock
  private ProductResponsePresenter productResponsePresenter;

  @Test
  void 전체_상품_조회() {
    // given
    when(findAllProductDsGateway.findAll()).thenReturn(products());
    // when
    interactor.execute();
    // then
    verify(findAllProductDsGateway, only()).findAll();
    verify(findScheduleUseCase, times(2)).execute(any());
    verify(findIdolMemberByIdUseCase, times(2)).execute(any());
    verify(productResponsePresenter, times(2)).create(any(), any(), any());
  }

  private static @NotNull Products products() {
    return new Products(List.of(FakeProductFactory.create(), FakeProductFactory.create()));
  }
}