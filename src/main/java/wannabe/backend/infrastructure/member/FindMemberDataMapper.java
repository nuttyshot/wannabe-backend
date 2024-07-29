package wannabe.backend.infrastructure.member;

import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wannabe.backend.member.entity.Member;
import wannabe.backend.member.usecase.findmember.FindMemberDsGateway;

@Service
@RequiredArgsConstructor
public class FindMemberDataMapper implements FindMemberDsGateway {

  private final JpaMemberRepository repository;

  @Override
  public Optional<Member> findByEmail(@NonNull String email) {
    return repository.findByEmail(email)
        .map(JpaMemberToMemberFactory::create);
  }
}
