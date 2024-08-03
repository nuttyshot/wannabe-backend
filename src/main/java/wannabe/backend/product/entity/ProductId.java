package wannabe.backend.product.entity;

public record ProductId(long value) {

  public ProductId {
    if (value <= 0) {
      throw new IllegalArgumentException("ProductId 값은 1 이상 이어야 합니다.");
    }
  }
}
