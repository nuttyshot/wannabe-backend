package wannabe.backend.idol.usecase.findidolmember;

import java.util.NoSuchElementException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wannabe.backend.idol.entity.IdolMember;

@Service
@RequiredArgsConstructor
public class FindIdolMemberInteractor implements FindIdolMemberUseCase {

  @Override
  public IdolMember find(@NonNull String name) throws NoSuchElementException {
    return null;
  }
}
