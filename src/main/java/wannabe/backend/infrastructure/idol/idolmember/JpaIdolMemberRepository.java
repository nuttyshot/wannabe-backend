package wannabe.backend.infrastructure.idol.idolmember;

import java.util.Optional;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaIdolMemberRepository extends JpaRepository<JpaIdolMember, Long> {

  Optional<JpaIdolMember> findByName(@NonNull String name);
}