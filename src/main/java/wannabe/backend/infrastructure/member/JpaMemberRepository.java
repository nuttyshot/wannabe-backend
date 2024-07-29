package wannabe.backend.infrastructure.member;

import java.util.Optional;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaMemberRepository extends JpaRepository<JpaMember, Long> {

  Optional<JpaMember> findByEmail(@NonNull String email);
}
