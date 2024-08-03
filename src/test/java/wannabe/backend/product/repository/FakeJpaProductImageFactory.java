package wannabe.backend.product.repository;

public class FakeJpaProductImageFactory {

  public static JpaProductImage create(JpaProduct product) {
    return JpaProductImage.builder()
        .product(product)
        .url("MOCK_URL")
        .sequence(1L)
        .build();
  }
}
