package wannabe.backend.product.interactor;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wannabe.backend.product.gateway.FindAllProductDsGateway;
import wannabe.backend.product.presenter.ProductsResponsePresenter;
import wannabe.backend.product.usecase.FindAllProductUseCase;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FindAllProductInteractor implements FindAllProductUseCase {

  private final FindAllProductDsGateway findAllProductDsGateway;
  private final ProductsResponsePresenter productsResponsePresenter;

  @Override
  public ProductsResponse execute() {
    val products = findAllProductDsGateway.findAll();
    return productsResponsePresenter.create(products);
  }
}
