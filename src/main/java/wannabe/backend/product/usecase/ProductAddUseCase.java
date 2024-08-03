package wannabe.backend.product.usecase;

import lombok.NonNull;
import wannabe.backend.product.dto.AddProductRequest;

public interface ProductAddUseCase {

  void addProduct(@NonNull AddProductRequest command);
}
