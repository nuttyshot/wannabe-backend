package wannabe.backend.member.usecase.findmember;

import java.util.Optional;
import lombok.NonNull;
import wannabe.backend.infrastructure.member.Member;

public interface FindMemberPort {

  Optional<Member> findByEmail(@NonNull String email);
}
