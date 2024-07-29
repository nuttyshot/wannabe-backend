package wannabe.backend.infrastructure.product;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import wannabe.backend.infrastructure.product.productimage.JpaProductImage;
import wannabe.backend.infrastructure.product.productimage.JpaProductImageRepository;
import wannabe.backend.product.entity.Product;
import wannabe.backend.product.usecase.addproduct.AddProductDsGateway;

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
