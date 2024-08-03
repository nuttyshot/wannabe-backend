package wannabe.backend.idol.usecase;

import java.util.Optional;
import lombok.NonNull;
import wannabe.backend.idol.entity.IdolMember;
import wannabe.backend.idol.entity.IdolMemberId;

public interface FindIdolMemberDsGateway {

  Optional<IdolMember> findByName(@NonNull String name);

  Optional<IdolMember> findById(@NonNull IdolMemberId id);
}
