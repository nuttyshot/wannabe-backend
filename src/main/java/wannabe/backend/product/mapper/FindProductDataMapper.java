package wannabe.backend.product.mapper;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import wannabe.backend.product.repository.ProductRepository;
import wannabe.backend.product.repository.ProductImageEntity;
import wannabe.backend.product.repository.ProductImageRepository;
import wannabe.backend.product.domain.Product;
import wannabe.backend.product.gateway.FindProductDsGateway;

@Service
@RequiredArgsConstructor
public class FindProductDataMapper implements FindProductDsGateway {

  private final ProductRepository productRepository;
  private final ProductImageRepository productImageRepository;

  @Override
  public Optional<Product> findById(long productId) {
    val product = productRepository.findById(productId);
    val images = productImageRepository.findByProductId(productId)
        .stream().map(ProductImageEntity::getUrl).toList();
    return product.map(i -> JpaProductToProductFactory.create(i, images));
  }
}
