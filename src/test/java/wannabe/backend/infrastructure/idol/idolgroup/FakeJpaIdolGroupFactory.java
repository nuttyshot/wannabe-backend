package wannabe.backend.infrastructure.idol.idolgroup;

public class FakeJpaIdolGroupFactory {

  public static JpaIdolGroup create() {
    return JpaIdolGroup.builder()
        .name("MOCK_NAME")
        .build();
  }
}
