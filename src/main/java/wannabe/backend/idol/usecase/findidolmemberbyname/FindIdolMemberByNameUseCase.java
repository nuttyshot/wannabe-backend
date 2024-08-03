package wannabe.backend.idol.usecase.findidolmemberbyname;

import java.util.NoSuchElementException;
import lombok.NonNull;
import wannabe.backend.idol.entity.IdolMember;

public interface FindIdolMemberByNameUseCase {

  IdolMember execute(@NonNull String name) throws NoSuchElementException;
}
