package wannabe.backend.product.usecase.findproduct;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import wannabe.backend.product.FakeProductFactory;
import wannabe.backend.product.entity.Color;
import wannabe.backend.product.entity.Product;

@ExtendWith(MockitoExtension.class)
class FindProductInteractorTest {

  @InjectMocks
  private FindProductInteractor interactor;

  @Mock
  private FindProductDsGateway gateway;

  @Mock
  private FindProductPresenter presenter;

  @Test
  void 상품_조회() {
    // given
    when(gateway.findById(anyLong())).thenReturn(FakeProductFactory.create());
    when(presenter.create(any())).thenReturn(response());
    // when
    interactor.findProduct(1L);
    // then
    verify(gateway, only()).findById(anyLong());
    verify(presenter, only()).create(any());
  }

  private FindProductResponse response() {
    return FindProductResponse.builder()
        .imageUrls(List.of())
        .scheduleDate(LocalDateTime.MIN)
        .idolMemberName("MOCK_IDOL_MEMBER_NAME")
        .productName("MOCK_PRODUCT_NAME")
        .hashTags(List.of())
        .isLike(false)
        .color(Color.BLACK)
        .build();
  }
}