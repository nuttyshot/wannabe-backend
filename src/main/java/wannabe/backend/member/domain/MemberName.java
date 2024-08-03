package wannabe.backend.member.domain;

import lombok.Getter;

@Getter
public class MemberName {

  private final String name;

  public MemberName(String name) {
    this.name = name;
  }
}
