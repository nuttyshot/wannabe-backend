package wannabe.backend.product.mapper;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import wannabe.backend.product.repository.JpaProductRepository;
import wannabe.backend.product.repository.JpaProductImage;
import wannabe.backend.product.repository.JpaProductImageRepository;
import wannabe.backend.product.domain.Product;
import wannabe.backend.product.gateway.FindProductDsGateway;

@Service
@RequiredArgsConstructor
public class FindProductDataMapper implements FindProductDsGateway {

  private final JpaProductRepository productRepository;
  private final JpaProductImageRepository productImageRepository;

  @Override
  public Optional<Product> findById(long productId) {
    val product = productRepository.findById(productId);
    val images = productImageRepository.findByProductId(productId)
        .stream().map(JpaProductImage::getUrl).toList();
    return product.map(i -> JpaProductToProductFactory.create(i, images));
  }
}
