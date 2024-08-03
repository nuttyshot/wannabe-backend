package wannabe.backend.idol.usecase.findidolmemberbyid;

import java.util.NoSuchElementException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wannabe.backend.idol.entity.IdolMember;
import wannabe.backend.idol.entity.IdolMemberId;
import wannabe.backend.idol.usecase.FindIdolMemberDsGateway;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FindIdolMemberByIdInteractor implements FindIdolMemberByIdUseCase {

  private final FindIdolMemberDsGateway gateway;

  @Override
  public IdolMember execute(@NonNull IdolMemberId id) throws NoSuchElementException {
    return gateway.findById(id)
        .orElseThrow(() -> new NoSuchElementException("아이돌 멤버를 찾을 수 없습니다 : " + id));
  }
}
