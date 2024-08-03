package wannabe.backend.like.interactor;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import wannabe.backend.like.gateway.CheckProductLikeStatusDsGateway;
import wannabe.backend.product.domain.ProductId;

@ExtendWith(MockitoExtension.class)
class CheckProductLikeStatusInteractorTest {

  @InjectMocks
  private CheckProductLikeStatusInteractor interactor;

  @Mock
  private CheckProductLikeStatusDsGateway gateway;

  @Test
  void 상품_좋아요_여부_조회() {
    // given
    // when
    interactor.execute(new ProductId(1L));
    // then
    verify(gateway, only()).getUserLikeStatusForProduct(any());
  }
}