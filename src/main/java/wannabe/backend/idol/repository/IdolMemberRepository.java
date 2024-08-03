package wannabe.backend.idol.repository;

import java.util.Optional;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdolMemberRepository extends JpaRepository<IdolMemberEntity, Long> {

  Optional<IdolMemberEntity> findByName(@NonNull String name);
}
