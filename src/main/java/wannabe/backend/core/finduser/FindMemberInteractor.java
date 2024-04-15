package wannabe.backend.core.finduser;

import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FindMemberInteractor implements FindMemberPort {

  private final MemberRepository memberRepository;

  @Override
  public Optional<Member> findByEmail(@NonNull String email) {
    return memberRepository.findByEmail(email);
  }
}
