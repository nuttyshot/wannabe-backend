package wannabe.backend.member.gateway;

import lombok.NonNull;
import wannabe.backend.member.domain.Member;

public interface SignupMemberDsGateway {

  Member save(@NonNull Member member);
}
