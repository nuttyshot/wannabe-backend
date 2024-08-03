package wannabe.backend.member.mapper;

import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wannabe.backend.member.repository.MemberRepository;
import wannabe.backend.member.domain.Member;
import wannabe.backend.member.gateway.FindMemberDsGateway;

@Service
@RequiredArgsConstructor
public class FindMemberDataMapper implements FindMemberDsGateway {

  private final MemberRepository repository;

  @Override
  public Optional<Member> findByEmail(@NonNull String email) {
    return repository.findByEmail(email)
        .map(MemberEntityToMemberMapper::create);
  }
}
