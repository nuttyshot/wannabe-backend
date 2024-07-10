package wannabe.backend.core.member;

import static jakarta.persistence.EnumType.STRING;
import static lombok.AccessLevel.*;

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
@Builder(access = PACKAGE)
@AllArgsConstructor(access = PACKAGE)
@NoArgsConstructor(access = PROTECTED)
@Entity
public class Member extends Audit {

  @Getter
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "email", length = 100, nullable = false, unique = true)
  private String email;

  @Getter
  @Column(name = "birthday", nullable = false)
  private LocalDate birthday;

  @Column(name = "nickname", length = 255, nullable = false)
  private String nickname;

  @Column(name = "name", length = 50, nullable = false)
  private String name;

  @Getter
  @Enumerated(EnumType.STRING)
  @Column(name = "age_range", length = 10, nullable = false)
  private AgeRange ageRange;

  @Enumerated(STRING)
  @Column(name = "provider", length = 20, nullable = false)
  private Provider provider;
}
