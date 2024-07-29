package wannabe.backend.product.usecase.findproduct;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FindProductInteractor implements FindProductUseCase {

  private final FindProductDsGateway gateway;
  private final FindProductPresenter presenter;

  @Override
  public FindProductResponse findProduct(long productId) {
    val product = gateway.findById(productId);
    return presenter.create(product);
  }
}
