package wannabe.backend.member.domain;

import lombok.Getter;

@Getter
public class Nickname {

  private final String nickname;

  public Nickname(String nickname) {
    this.nickname = nickname;
  }
}
