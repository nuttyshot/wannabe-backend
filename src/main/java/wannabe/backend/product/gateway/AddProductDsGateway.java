package wannabe.backend.product.gateway;

import lombok.NonNull;
import wannabe.backend.product.domain.Product;

public interface AddProductDsGateway {

  void addProduct(@NonNull Product product);
}
