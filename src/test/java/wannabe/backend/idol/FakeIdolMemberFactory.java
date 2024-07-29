package wannabe.backend.idol;

import wannabe.backend.idol.entity.IdolMember;
import wannabe.backend.idol.entity.IdolMemberId;

public class FakeIdolMemberFactory {

  public static IdolMember create() {
    return IdolMember.builder().id(new IdolMemberId(1L)).build();
  }
}
