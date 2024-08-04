package wannabe.backend.idol.mapper;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import wannabe.backend.idol.domain.IdolMember;
import wannabe.backend.idol.domain.IdolMemberId;
import wannabe.backend.idol.gateway.AddIdolMemberDsGateway;
import wannabe.backend.idol.repository.IdolMemberRepository;

@Service
@RequiredArgsConstructor
public class AddIdolMemberDataMapper implements AddIdolMemberDsGateway {

  private final IdolMemberRepository repository;

  @Override
  public IdolMemberId save(@NonNull IdolMember member) {
    val saveMember = repository.save(IdolMemberMapper.toEntity(member));
    return new IdolMemberId(saveMember.getId());
  }
}
