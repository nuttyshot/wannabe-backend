package wannabe.backend.idol.domain;

import lombok.Builder;

@Builder
public record FakeIdolGroup(Long id, String name) {

  public IdolGroup create() {
    return IdolGroup.builder()
        .id(id != null ? new IdolGroupId(id) : null)
        .name(new IdolGroupName(name))
        .build();
  }
}
