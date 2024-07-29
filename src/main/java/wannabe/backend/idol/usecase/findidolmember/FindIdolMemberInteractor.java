package wannabe.backend.idol.usecase.findidolmember;

import java.util.NoSuchElementException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wannabe.backend.idol.entity.IdolMember;

@Service
@RequiredArgsConstructor
public class FindIdolMemberInteractor implements FindIdolMemberUseCase {

  private final FindIdolMemberDsGateway gateway;

  @Override
  public IdolMember find(@NonNull String name) throws NoSuchElementException {
    return gateway.findByName(name)
        .orElseThrow(() -> new NoSuchElementException("아이돌 멤버를 찾을 수 없습니다 : " + name));
  }
}
