package wannabe.backend.product.repository;

public class FakeProductImageEntityFactory {

  public static ProductImageEntity create(ProductEntity product) {
    return ProductImageEntity.builder()
        .product(product)
        .url("MOCK_URL")
        .sequence(1L)
        .build();
  }
}
