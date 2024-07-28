package wannabe.backend.core.product.usecase;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductAddInteractor implements ProductAddUseCase {

  @Override
  public void addProduct(@NonNull ProductAddRequest request) {
  }
}
