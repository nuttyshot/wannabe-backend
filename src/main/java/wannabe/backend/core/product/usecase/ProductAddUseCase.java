package wannabe.backend.core.product.usecase;

import lombok.NonNull;

public interface ProductAddUseCase {

  void addProduct(@NonNull ProductAddRequest command);
}
