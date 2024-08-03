package wannabe.backend.member.interactor;

import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wannabe.backend.member.domain.Member;
import wannabe.backend.member.usecase.FindMemberUseCase;
import wannabe.backend.member.gateway.FindMemberDsGateway;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FindMemberInteractor implements FindMemberUseCase {

  private final FindMemberDsGateway gateway;

  @Override
  public Optional<Member> findByEmail(@NonNull String email) {
    return gateway.findByEmail(email);
  }
}
