package wannabe.backend.idol.mapper;

import lombok.NonNull;
import wannabe.backend.idol.domain.IdolGroup;
import wannabe.backend.idol.domain.IdolMember;
import wannabe.backend.idol.domain.IdolMemberFactory;
import wannabe.backend.idol.repository.IdolGroupEntity;
import wannabe.backend.idol.repository.IdolMemberEntity;

public class IdolGroupMapper {

  private IdolGroupMapper() {
  }

  public static IdolGroupEntity toEntity(@NonNull IdolGroup group) {
    return IdolGroupEntity.builder()
        .name(group.name().value())
        .build();
  }
}
