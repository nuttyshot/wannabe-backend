package wannabe.backend.infrastructure.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaScheduleRepository extends JpaRepository<JpaSchedule, Long> {

}
