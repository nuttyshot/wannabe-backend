package wannabe.backend.idol.domain;

public class FakeIdolMemberFactory {

  public static IdolMember create() {
    return IdolMember.builder()
        .id(new IdolMemberId(1L))
        .name(new IdolMemberName("MEMBER_NAME"))
        .build();
  }
}
