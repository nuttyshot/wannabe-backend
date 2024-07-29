package wannabe.backend.idol.usecase.findidolmember;

import java.util.NoSuchElementException;
import lombok.NonNull;
import wannabe.backend.idol.entity.IdolMember;

public interface FindIdolMemberUseCase {

  IdolMember find(@NonNull String name) throws NoSuchElementException;
}
