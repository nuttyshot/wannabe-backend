package wannabe.backend.idol.interactor;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wannabe.backend.idol.domain.IdolMember;
import wannabe.backend.idol.domain.IdolMemberId;
import wannabe.backend.idol.gateway.AddIdolMemberDsGateway;
import wannabe.backend.idol.usecase.AddIdolMemberUseCase;

@Service
@Transactional
@RequiredArgsConstructor
public class AddIdolMemberInteractor implements AddIdolMemberUseCase {

  private final AddIdolMemberDsGateway addIdolMemberDsGateway;

  @Override
  public IdolMemberId execute(@NonNull IdolMember member) {
    return addIdolMemberDsGateway.save(member);
  }
}
