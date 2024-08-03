package wannabe.backend.member.gateway;

import java.util.Optional;
import lombok.NonNull;
import wannabe.backend.member.domain.Member;

public interface FindMemberDsGateway {

  Optional<Member> findByEmail(@NonNull String email);
}
