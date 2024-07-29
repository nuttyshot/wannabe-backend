package wannabe.backend.product.usecase.addproduct;

import lombok.NonNull;
import wannabe.backend.product.entity.Product;

public interface AddProductDsGateway {

  void addProduct(@NonNull Product product);
}
