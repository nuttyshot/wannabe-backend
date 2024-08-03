package wannabe.backend.idol.domain;

import lombok.NonNull;

public class IdolGroupFactory {

  private IdolGroupFactory() {
  }

  public static IdolGroup create(@NonNull String name) {
    return IdolGroup.builder()
        .name(new IdolGroupName(name))
        .build();
  }
}
