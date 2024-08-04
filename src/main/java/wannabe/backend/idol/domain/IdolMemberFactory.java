package wannabe.backend.idol.domain;

import lombok.NonNull;

public class IdolMemberFactory {

  private IdolMemberFactory() {
  }

  public static IdolMember create(@NonNull Long id, @NonNull String name, long groupId) {
    return IdolMember.builder()
        .id(new IdolMemberId(id))
        .name(new IdolMemberName(name))
        .groupId(new IdolGroupId(groupId))
        .build();
  }

  public static IdolMember create(@NonNull String name, @NonNull IdolGroupId groupId) {
    return IdolMember.builder()
        .name(new IdolMemberName(name))
        .groupId(groupId)
        .build();
  }
}
