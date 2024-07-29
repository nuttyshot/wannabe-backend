package wannabe.backend.product.usecase.addproduct;

import lombok.NonNull;

public interface ProductAddUseCase {

  void addProduct(@NonNull ProductAddRequest command);
}
