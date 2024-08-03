package wannabe.backend.product.usecase;

import wannabe.backend.product.dto.FindProductResponse;

public interface FindProductUseCase {

  FindProductResponse findProduct(long productId);
}
