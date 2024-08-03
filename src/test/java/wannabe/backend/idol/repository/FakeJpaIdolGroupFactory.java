package wannabe.backend.idol.repository;

public class FakeJpaIdolGroupFactory {

  public static JpaIdolGroup create() {
    return JpaIdolGroup.builder()
        .name("MOCK_NAME")
        .build();
  }
}
