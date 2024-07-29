package wannabe.backend.product.usecase.findproduct;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import wannabe.backend.product.entity.Product;

@Service
public class FindProductFormatter implements FindProductPresenter {

  @Override
  public FindProductResponse create(@NonNull Product product) {
    return null;
  }
}
