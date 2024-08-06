package wannabe.backend.product.presenter;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import wannabe.backend.product.domain.Products;
import wannabe.backend.product.interactor.ProductsResponse;

@Service
public class ProductsResponseFormatter implements ProductsResponsePresenter {

  @Override
  public ProductsResponse create(@NonNull Products products) {
    return null;
  }
}
