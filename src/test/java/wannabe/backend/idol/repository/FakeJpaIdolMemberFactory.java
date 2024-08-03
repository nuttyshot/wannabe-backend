package wannabe.backend.idol.repository;

public class FakeJpaIdolMemberFactory {

  public static JpaIdolMember create(JpaIdolGroup idolGroup) {
    return JpaIdolMember.builder()
        .group(idolGroup)
        .name("MOCK_NAME")
        .build();
  }
}
