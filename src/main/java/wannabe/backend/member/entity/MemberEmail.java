package wannabe.backend.member.entity;

import lombok.Getter;

@Getter
public class MemberEmail {

  private final String email;

  public MemberEmail(String email) {
    this.email = email;
  }
}
