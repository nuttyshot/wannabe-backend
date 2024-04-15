package wannabe.backend.core.finduser;

import java.util.Optional;
import lombok.NonNull;
import wannabe.backend.core.member.Member;

public interface FindMemberPort {

  Optional<Member> findByEmail(@NonNull String email);
}
