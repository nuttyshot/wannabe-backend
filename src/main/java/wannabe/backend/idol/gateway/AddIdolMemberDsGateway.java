package wannabe.backend.idol.gateway;

import lombok.NonNull;
import wannabe.backend.idol.domain.IdolMember;
import wannabe.backend.idol.domain.IdolMemberId;

public interface AddIdolMemberDsGateway {

  IdolMemberId save(@NonNull IdolMember member);
}
