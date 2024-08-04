package wannabe.backend.idol.repository;

public class FakeIdolGroupEntityFactory {

  public static IdolGroupEntity create() {
    return IdolGroupEntity.builder()
        .name("MOCK_NAME")
        .build();
  }

  public static IdolGroupEntity create(Long id) {
    return IdolGroupEntity.builder()
        .id(id)
        .name("MOCK_NAME")
        .build();
  }

  public static IdolGroupEntity create(String name) {
    return IdolGroupEntity.builder()
        .name(name)
        .build();
  }
}
