package wannabe.backend.product.mapper;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import wannabe.backend.product.repository.JpaProduct;
import wannabe.backend.product.repository.JpaProductRepository;
import wannabe.backend.product.repository.JpaProductImage;
import wannabe.backend.product.repository.JpaProductImageRepository;
import wannabe.backend.product.domain.Product;
import wannabe.backend.product.gateway.AddProductDsGateway;

@Service
@RequiredArgsConstructor
public class AddProductDataMapper implements AddProductDsGateway {

  private final JpaProductRepository productRepository;
  private final JpaProductImageRepository productImageRepository;

  @Override
  public void addProduct(@NonNull Product product) {
    val savedProduct = productRepository.save(new JpaProduct(product));
    product.images().images()
        .forEach((key, value) -> productImageRepository.save(
            new JpaProductImage(savedProduct.getId(), key, value)));
  }
}
