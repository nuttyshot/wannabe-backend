package wannabe.backend.idol.usecase.findidolmember;

import java.util.Optional;
import lombok.NonNull;
import wannabe.backend.idol.entity.IdolMember;

public interface FindIdolMemberDsGateway {

  Optional<IdolMember> findByName(@NonNull String name);
}
