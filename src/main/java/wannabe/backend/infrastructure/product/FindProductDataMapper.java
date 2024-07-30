package wannabe.backend.infrastructure.product;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import wannabe.backend.infrastructure.product.productimage.JpaProductImage;
import wannabe.backend.infrastructure.product.productimage.JpaProductImageRepository;
import wannabe.backend.product.entity.Product;
import wannabe.backend.product.usecase.findproduct.FindProductDsGateway;

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
