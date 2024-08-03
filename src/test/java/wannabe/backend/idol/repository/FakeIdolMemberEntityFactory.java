package wannabe.backend.idol.repository;

public class FakeIdolMemberEntityFactory {

  public static IdolMemberEntity create(IdolGroupEntity idolGroup) {
    return IdolMemberEntity.builder()
        .group(idolGroup)
        .name("MOCK_NAME")
        .build();
  }
}
