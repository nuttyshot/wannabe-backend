package wannabe.backend.idol.repository;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PROTECTED;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Table(name = "idol_group")
@Builder
@AllArgsConstructor(access = PACKAGE)
@NoArgsConstructor(access = PROTECTED)
@Entity
public class JpaIdolGroup {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name", length = 100, nullable = false)
  private String name;
}
