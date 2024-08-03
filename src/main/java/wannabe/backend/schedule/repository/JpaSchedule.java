package wannabe.backend.schedule.repository;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PROTECTED;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import wannabe.backend.common.repository.Audit;

@Getter
@ToString
@Table(name = "schedule")
@Builder
@AllArgsConstructor(access = PACKAGE)
@NoArgsConstructor(access = PROTECTED)
@Entity
public class JpaSchedule extends Audit {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name", length = 100, nullable = false)
  private String name;

  @Column(name = "date", nullable = false)
  private LocalDateTime dateTime;
}
