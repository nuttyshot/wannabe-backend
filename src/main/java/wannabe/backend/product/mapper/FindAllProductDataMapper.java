package wannabe.backend.product.mapper;

import org.springframework.stereotype.Service;
import wannabe.backend.product.domain.Products;
import wannabe.backend.product.gateway.FindAllProductDsGateway;

@Service
public class FindAllProductDataMapper implements FindAllProductDsGateway {

  @Override
  public Products findAll() {
    return null;
  }
}
