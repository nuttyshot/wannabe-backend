package wannabe.backend.member.usecase.findmember;

import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wannabe.backend.member.entity.Member;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FindMemberInteractor implements FindMemberPort {

  private final FindMemberDsGateway gateway;

  @Override
  public Optional<Member> findByEmail(@NonNull String email) {
    return gateway.findByEmail(email);
  }
}
