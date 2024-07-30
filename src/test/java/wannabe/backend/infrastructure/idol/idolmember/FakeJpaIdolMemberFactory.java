package wannabe.backend.infrastructure.idol.idolmember;

import wannabe.backend.infrastructure.idol.idolgroup.JpaIdolGroup;

public class FakeJpaIdolMemberFactory {

  public static JpaIdolMember create(JpaIdolGroup idolGroup) {
    return JpaIdolMember.builder()
        .group(idolGroup)
        .name("MOCK_NAME")
        .build();
  }
}
