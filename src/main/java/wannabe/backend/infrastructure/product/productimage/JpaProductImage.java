package wannabe.backend.infrastructure.product.productimage;

import static jakarta.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PROTECTED;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import wannabe.backend.infrastructure.product.JpaProduct;
import wannabe.backend.product.entity.ImageSequence;
import wannabe.backend.product.entity.ImageUrl;

@ToString
@Table(name = "product_image")
@Builder(access = PACKAGE)
@AllArgsConstructor(access = PACKAGE)
@NoArgsConstructor(access = PROTECTED)
@Entity
public class JpaProductImage {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "product_id", nullable = false)
  private JpaProduct product;

  @Column(name = "url", length = 255, nullable = false)
  private String url;

  @Column(name = "sequence", nullable = false)
  private long sequence;

  public JpaProductImage(@NonNull Long productId, @NonNull ImageSequence sequence,
      @NonNull ImageUrl url) {
    this.product = new JpaProduct(productId);
    this.sequence = sequence.sequence();
    this.url = url.url();
  }
}
