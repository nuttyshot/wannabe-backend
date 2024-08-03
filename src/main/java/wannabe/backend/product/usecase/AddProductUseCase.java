package wannabe.backend.product.usecase;

import lombok.NonNull;
import wannabe.backend.product.dto.AddProductRequest;

public interface AddProductUseCase {

  void execute(@NonNull AddProductRequest command);
}
