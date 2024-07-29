package wannabe.backend.product.usecase.findproduct;

import lombok.NonNull;
import wannabe.backend.product.entity.Product;

public interface FindProductPresenter {

  FindProductResponse create(@NonNull Product product);
}
