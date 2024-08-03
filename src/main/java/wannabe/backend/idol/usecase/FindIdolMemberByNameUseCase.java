package wannabe.backend.idol.usecase;

import java.util.NoSuchElementException;
import lombok.NonNull;
import wannabe.backend.idol.domain.IdolMember;

public interface FindIdolMemberByNameUseCase {

  IdolMember execute(@NonNull String name) throws NoSuchElementException;
}
