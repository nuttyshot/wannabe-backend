package wannabe.backend.infrastructure.idol.idolmember;

import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wannabe.backend.idol.usecase.findidolmember.FindIdolMemberDsGateway;
import wannabe.backend.idol.entity.IdolMember;

@Service
@RequiredArgsConstructor
public class FindIdolMemberDataMapper implements FindIdolMemberDsGateway {

  private final JpaIdolMemberRepository repository;

  @Override
  public Optional<IdolMember> findByName(@NonNull String name) {
    return repository.findByName(name)
        .map(JpaIdolMemberToIdolMemberFactory::create);
  }
}
