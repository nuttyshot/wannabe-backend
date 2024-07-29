package wannabe.backend.infrastructure.idol.idolmember;

import static jakarta.persistence.FetchType.*;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import wannabe.backend.infrastructure.idol.idolgroup.JpaIdolGroup;

@Getter
@ToString
@Table(name = "idol_member")
@Builder
@AllArgsConstructor(access = PACKAGE)
@NoArgsConstructor(access = PROTECTED)
@Entity
public class JpaIdolMember {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "idol_group_id", nullable = false)
  private JpaIdolGroup group;

  @Column(name = "name", length = 100, nullable = false)
  private String name;
}
