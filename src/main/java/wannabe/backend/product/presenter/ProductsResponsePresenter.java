package wannabe.backend.product.presenter;

import lombok.NonNull;
import wannabe.backend.product.domain.Products;
import wannabe.backend.product.interactor.ProductsResponse;

public interface ProductsResponsePresenter {

  ProductsResponse create(@NonNull Products products);
}
