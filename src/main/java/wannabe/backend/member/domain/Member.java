package wannabe.backend.member.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Member {

  private final MemberId id;
  private final MemberEmail email;
  private final MemberBirthday birthday;
  private final Nickname nickname;
  private final MemberName name;
  private final AgeRange ageRange;
  private final Provider provider;

  @Builder
  public Member(MemberId id, MemberEmail email, MemberBirthday birthday, Nickname nickname,
      MemberName name, AgeRange ageRange, Provider provider) {
    this.id = id;
    this.email = email;
    this.birthday = birthday;
    this.nickname = nickname;
    this.name = name;
    this.ageRange = ageRange;
    this.provider = provider;
  }
}
