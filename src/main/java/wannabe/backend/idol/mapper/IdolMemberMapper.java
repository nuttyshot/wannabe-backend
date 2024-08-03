package wannabe.backend.idol.mapper;

import lombok.NonNull;
import wannabe.backend.idol.domain.IdolMember;
import wannabe.backend.idol.domain.IdolMemberFactory;
import wannabe.backend.idol.repository.IdolMemberEntity;

public class IdolMemberMapper {

  private IdolMemberMapper() {
  }

  public static IdolMember toDomain(@NonNull IdolMemberEntity entity) {
    return IdolMemberFactory.create(entity.getId(), entity.getName());
  }
}
