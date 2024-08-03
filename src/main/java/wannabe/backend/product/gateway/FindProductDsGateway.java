package wannabe.backend.product.gateway;

import java.util.Optional;
import wannabe.backend.product.domain.Product;

public interface FindProductDsGateway {

  Optional<Product> findById(long productId);
}
