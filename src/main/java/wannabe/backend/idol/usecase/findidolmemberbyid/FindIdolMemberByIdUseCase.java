package wannabe.backend.idol.usecase.findidolmemberbyid;

import java.util.NoSuchElementException;
import lombok.NonNull;
import wannabe.backend.idol.entity.IdolMember;
import wannabe.backend.idol.entity.IdolMemberId;

public interface FindIdolMemberByIdUseCase {

  IdolMember execute(@NonNull IdolMemberId id) throws NoSuchElementException;
}
