package wannabe.backend.member.usecase.signupmember;

import lombok.NonNull;
import wannabe.backend.member.entity.Member;

public interface SignupMemberDsGateway {

  Member save(@NonNull Member member);
}
