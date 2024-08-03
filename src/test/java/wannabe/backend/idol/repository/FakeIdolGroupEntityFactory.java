package wannabe.backend.idol.repository;

public class FakeIdolGroupEntityFactory {

  public static IdolGroupEntity create() {
    return IdolGroupEntity.builder()
        .name("MOCK_NAME")
        .build();
  }
}
