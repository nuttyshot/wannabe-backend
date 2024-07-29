package wannabe.backend.product.usecase.findproduct;

import wannabe.backend.product.entity.Product;

public interface FindProductDsGateway {

  Product findById(long productId);
}
