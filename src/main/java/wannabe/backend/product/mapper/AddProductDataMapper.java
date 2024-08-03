package wannabe.backend.product.mapper;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import wannabe.backend.product.repository.ProductEntity;
import wannabe.backend.product.repository.ProductRepository;
import wannabe.backend.product.repository.ProductImageEntity;
import wannabe.backend.product.repository.ProductImageRepository;
import wannabe.backend.product.domain.Product;
import wannabe.backend.product.gateway.AddProductDsGateway;

@Service
@RequiredArgsConstructor
public class AddProductDataMapper implements AddProductDsGateway {

  private final ProductRepository productRepository;
  private final ProductImageRepository productImageRepository;

  @Override
  public void addProduct(@NonNull Product product) {
    val savedProduct = productRepository.save(new ProductEntity(product));
    product.images().images()
        .forEach((key, value) -> productImageRepository.save(
            new ProductImageEntity(savedProduct.getId(), key, value)));
  }
}
