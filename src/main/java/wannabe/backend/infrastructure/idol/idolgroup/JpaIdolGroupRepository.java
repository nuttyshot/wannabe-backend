package wannabe.backend.infrastructure.idol.idolgroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaIdolGroupRepository extends JpaRepository<JpaIdolGroup, Long> {

}
