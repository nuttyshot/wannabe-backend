package wannabe.backend.idol.mapper;

import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wannabe.backend.idol.domain.IdolMemberId;
import wannabe.backend.idol.gateway.FindIdolMemberDsGateway;
import wannabe.backend.idol.domain.IdolMember;
import wannabe.backend.idol.repository.JpaIdolMemberRepository;

@Service
@RequiredArgsConstructor
public class FindIdolMemberDataMapper implements FindIdolMemberDsGateway {

  private final JpaIdolMemberRepository repository;

  @Override
  public Optional<IdolMember> findByName(@NonNull String name) {
    return repository.findByName(name)
        .map(JpaIdolMemberToIdolMemberFactory::create);
  }

  @Override
  public Optional<IdolMember> findById(@NonNull IdolMemberId id) {
    return Optional.empty();
  }
}
