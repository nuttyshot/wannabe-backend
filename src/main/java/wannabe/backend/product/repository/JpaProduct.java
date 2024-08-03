package wannabe.backend.product.repository;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import wannabe.backend.common.repository.Audit;
import wannabe.backend.idol.repository.JpaIdolMember;
import wannabe.backend.schedule.repository.JpaSchedule;
import wannabe.backend.product.domain.Color;
import wannabe.backend.product.domain.Product;
import wannabe.backend.product.domain.ProductType;
import wannabe.backend.product.domain.StyleType;

@Getter
@ToString
@Table(name = "product")
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
@Entity
public class JpaProduct extends Audit {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name", length = 100, nullable = false)
  private String name;

  @Column(name = "brand", length = 50)
  private String brand;

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "schedule_id", nullable = false)
  private JpaSchedule schedule;

  @Column(name = "price")
  private Integer price;

  @Enumerated(STRING)
  @Column(name = "productType", length = 50, nullable = false)
  private ProductType productType;

  @Column(name = "seller", length = 50)
  private String seller;

  @Column(name = "sales_link", length = 255)
  private String salesLink;

  @Enumerated(STRING)
  @Column(name = "color", length = 50, nullable = false)
  private Color color;

  @Enumerated(STRING)
  @Column(name = "style_type", length = 50)
  private StyleType styleType;

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "idol_member_id", nullable = false)
  private JpaIdolMember idolMember;

  public JpaProduct(@NonNull Product product) {
    this.name = product.name();
    this.schedule = JpaSchedule.builder().id(product.scheduleId().value()).build();
    this.price = product.price();
    this.productType = product.productType();
    this.salesLink = product.salesLink();
    this.color = product.color();
    this.styleType = product.styleType();
    this.idolMember = JpaIdolMember.builder().id(product.idolMemberId().id()).build();
  }
}
