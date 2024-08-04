package wannabe.backend.idol.usecase;

import lombok.NonNull;
import wannabe.backend.idol.domain.IdolMember;
import wannabe.backend.idol.domain.IdolMemberId;

public interface AddIdolMemberUseCase {

  IdolMemberId execute(@NonNull IdolMember member);
}
