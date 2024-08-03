package wannabe.backend.idol.domain;

import lombok.NonNull;

public class IdolMemberFactory {

  private IdolMemberFactory() {
  }

  public static IdolMember create(@NonNull Long id, @NonNull String name) {
    return IdolMember.builder()
        .id(new IdolMemberId(id))
        .name(new IdolMemberName(name))
        .build();
  }
}
