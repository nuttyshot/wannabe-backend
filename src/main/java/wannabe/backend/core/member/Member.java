package wannabe.backend.core.member;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import wannabe.backend.core.finduser.AgeRange;
import wannabe.backend.core.finduser.Audit;

@ToString
@Table(name = "member")
@Builder(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member extends Audit {

  @Getter
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "email", length = 255, nullable = false)
  private String email;

  @Getter
  @Column(name = "birthday")
  private LocalDate birthday;

  @Column(name = "nickname", length = 30)
  private String nickname;

  @Column(name = "name", length = 50)
  private String name;

  @Getter
  @Enumerated(EnumType.STRING)
  @Column(name = "age_range", length = 10)
  private AgeRange ageRange;

  @Column(name = "phone_no", length = 20)
  private String phoneNo;
}
