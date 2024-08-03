package wannabe.backend.idol.usecase;

import java.util.NoSuchElementException;
import lombok.NonNull;
import wannabe.backend.idol.domain.IdolMember;
import wannabe.backend.idol.domain.IdolMemberId;

public interface FindIdolMemberByIdUseCase {

  IdolMember execute(@NonNull IdolMemberId id) throws NoSuchElementException;
}
