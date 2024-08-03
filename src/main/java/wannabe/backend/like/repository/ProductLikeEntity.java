package wannabe.backend.like.repository;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import wannabe.backend.common.repository.Audit;
import wannabe.backend.member.repository.MemberEntity;
import wannabe.backend.product.repository.ProductEntity;

@Getter
@ToString
@Table(name = "product_like")
@AllArgsConstructor(access = PACKAGE)
@NoArgsConstructor(access = PROTECTED)
@Entity
public class ProductLikeEntity extends Audit {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "product_id", nullable = false)
  private ProductEntity product;

  @ManyToOne
  @JoinColumn(name = "member_id", nullable = false)
  private MemberEntity member;
}
