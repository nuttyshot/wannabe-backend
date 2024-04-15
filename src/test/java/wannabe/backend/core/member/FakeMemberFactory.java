package wannabe.backend.core.member;

public class FakeMemberFactory {

  public static Member create(String email) {
    return Member.builder().email(email).build();
  }
}
