package wannabe.backend.idol.interactor;

import java.util.NoSuchElementException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wannabe.backend.idol.domain.IdolMember;
import wannabe.backend.idol.usecase.FindIdolMemberByNameUseCase;
import wannabe.backend.idol.gateway.FindIdolMemberDsGateway;

@Service
@RequiredArgsConstructor
public class FindIdolMemberByNameInteractor implements FindIdolMemberByNameUseCase {

  private final FindIdolMemberDsGateway gateway;

  @Override
  public IdolMember execute(@NonNull String name) throws NoSuchElementException {
    return gateway.findByName(name)
        .orElseThrow(() -> new NoSuchElementException("아이돌 멤버를 찾을 수 없습니다 : " + name));
  }
}
