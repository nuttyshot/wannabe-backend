package wannabe.backend.idol.domain;

public class FakeIdolGroupFactory {

  public static IdolGroup create() {
    return IdolGroup.builder()
        .name(new IdolGroupName("GROUP_NAME"))
        .build();
  }

  public static IdolGroup create(String name) {
    return IdolGroup.builder()
        .name(new IdolGroupName(name))
        .build();
  }
}
