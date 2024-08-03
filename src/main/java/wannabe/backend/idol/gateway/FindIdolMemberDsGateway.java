package wannabe.backend.idol.gateway;

import java.util.Optional;
import lombok.NonNull;
import wannabe.backend.idol.domain.IdolMember;
import wannabe.backend.idol.domain.IdolMemberId;

public interface FindIdolMemberDsGateway {

  Optional<IdolMember> findByName(@NonNull String name);

  Optional<IdolMember> findById(@NonNull IdolMemberId id);
}
