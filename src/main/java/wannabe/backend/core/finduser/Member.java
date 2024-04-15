package wannabe.backend.core.finduser;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Table(name = "member")
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member extends Audit {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "email", length = 255, nullable = false)
  private String email;

  @Column(name = "birthday")
  private LocalDate birthday;

  @Column(name = "nickname", length = 30)
  private String nickname;

  @Column(name = "name", length = 50)
  private String name;

  @Enumerated(EnumType.STRING)
  @Column(name = "age_range", length = 10)
  private AgeRange ageRange;

  @Column(name = "phone_no", length = 20)
  private String phoneNo;
}
