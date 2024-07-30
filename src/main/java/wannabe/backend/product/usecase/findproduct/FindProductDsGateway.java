package wannabe.backend.product.usecase.findproduct;

import java.util.Optional;
import wannabe.backend.product.entity.Product;

public interface FindProductDsGateway {

  Optional<Product> findById(long productId);
}
