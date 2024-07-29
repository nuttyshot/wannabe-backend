package wannabe.backend.infrastructure.product;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import wannabe.backend.product.entity.Product;
import wannabe.backend.product.usecase.addproduct.AddProductDsGateway;

@Service
public class AddProductDataMapper implements AddProductDsGateway {

  @Override
  public void addProduct(@NonNull Product product) {
  }
}
