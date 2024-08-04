package wannabe.backend.idol.domain;

public class FakeIdolMemberFactory {

  public static IdolMember create() {
    return IdolMember.builder()
        .id(new IdolMemberId(1L))
        .name(new IdolMemberName("MEMBER_NAME"))
        .groupId(new IdolGroupId(2L))
        .build();
  }

  public static IdolMember create(String name, long groupId) {
    return IdolMember.builder()
        .name(new IdolMemberName(name))
        .groupId(new IdolGroupId(groupId))
        .build();
  }
}
