package wannabe.backend.member.usecase.findmember;

import java.util.Optional;
import lombok.NonNull;
import wannabe.backend.member.entity.Member;

public interface FindMemberDsGateway {

  Optional<Member> findByEmail(@NonNull String email);
}
