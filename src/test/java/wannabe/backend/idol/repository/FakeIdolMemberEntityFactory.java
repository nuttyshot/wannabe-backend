package wannabe.backend.idol.repository;

public class FakeIdolMemberEntityFactory {

  public static IdolMemberEntity create(IdolGroupEntity idolGroup) {
    return IdolMemberEntity.builder()
        .group(idolGroup)
        .name("MOCK_NAME")
        .build();
  }

  public static IdolMemberEntity create(Long memberId, Long groupId) {
    return IdolMemberEntity.builder()
        .id(memberId)
        .group(IdolGroupEntity.builder().id(groupId).build())
        .name("MEMBER_NAME")
        .build();
  }
}
