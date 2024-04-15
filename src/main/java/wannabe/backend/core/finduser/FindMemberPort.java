package wannabe.backend.core.finduser;

import java.util.Optional;
import lombok.NonNull;

public interface FindMemberPort {

  Optional<Member> findByEmail(@NonNull String email);
}
