package wannabe.backend.core.clothesimage;

import static jakarta.persistence.FetchType.*;
import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PROTECTED;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import wannabe.backend.core.clothes.Clothes;

@ToString
@Table(name = "clothes_image")
@Builder(access = PACKAGE)
@AllArgsConstructor(access = PACKAGE)
@NoArgsConstructor(access = PROTECTED)
@Entity
public class ClothesImage {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "clothes_id", nullable = false)
  private Clothes clothes;

  @Column(name = "id", length = 255, nullable = false)
  private String url;

  @Column(name = "id", nullable = false)
  private int sequence;
}
