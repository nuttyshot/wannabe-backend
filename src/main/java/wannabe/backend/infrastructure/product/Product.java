package wannabe.backend.infrastructure.product;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PROTECTED;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import wannabe.backend.infrastructure.common.Audit;
import wannabe.backend.infrastructure.idol.idolmember.IdolMember;

@ToString
@Table(name = "product")
@Builder(access = PACKAGE)
@AllArgsConstructor(access = PACKAGE)
@NoArgsConstructor(access = PROTECTED)
@Entity
public class Product extends Audit {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name", length = 100, nullable = false)
  private String name;

  @Column(name = "wearing_date", nullable = false)
  private LocalDate wearingDate;

  @Column(name = "price", nullable = false)
  private int price;

  @Enumerated(STRING)
  @Column(name = "type", length = 50, nullable = false)
  private ProductType productType;

  @Column(name = "purchase_link", length = 255)
  private String purchaseLink;

  @Enumerated(STRING)
  @Column(name = "color", length = 50, nullable = false)
  private Color color;

  @Enumerated(STRING)
  @Column(name = "style_type", length = 50)
  private StyleType styleType;

  @OneToOne(fetch = LAZY)
  @JoinColumn(name = "idol_member_id", nullable = false)
  private IdolMember idolMember;
}
