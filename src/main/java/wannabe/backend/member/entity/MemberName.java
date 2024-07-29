package wannabe.backend.member.entity;

import lombok.Getter;

@Getter
public class MemberName {

  private final String name;

  public MemberName(String name) {
    this.name = name;
  }
}
