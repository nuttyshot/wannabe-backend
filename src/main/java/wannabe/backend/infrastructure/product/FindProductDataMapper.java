package wannabe.backend.infrastructure.product;

import org.springframework.stereotype.Service;
import wannabe.backend.product.entity.Product;
import wannabe.backend.product.usecase.findproduct.FindProductDsGateway;

@Service
public class FindProductDataMapper implements FindProductDsGateway {

  @Override
  public Product findById(long productId) {
    return null;
  }
}
