package wannabe.backend.member.usecase;

import java.util.Optional;
import lombok.NonNull;
import wannabe.backend.member.domain.Member;

public interface FindMemberUseCase {

  Optional<Member> findByEmail(@NonNull String email);
}
