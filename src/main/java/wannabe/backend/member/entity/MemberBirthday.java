package wannabe.backend.member.entity;

import java.time.LocalDate;
import lombok.Getter;

@Getter
public class MemberBirthday {

  private final LocalDate birthday;

  public MemberBirthday(LocalDate birthday) {
    this.birthday = birthday;
  }
}
