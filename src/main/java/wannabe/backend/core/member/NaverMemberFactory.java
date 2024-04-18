package wannabe.backend.core.member;

import java.time.LocalDate;
import lombok.NonNull;
import lombok.experimental.ExtensionMethod;
import lombok.val;
import org.springframework.stereotype.Service;
import wannabe.backend.core.date.DateExtension;
import wannabe.backend.core.finduser.AgeRange;
import wannabe.backend.core.oauth2.adapter.OAuth2Member;

@ExtensionMethod(DateExtension.class)
@Service
public class NaverMemberFactory implements MemberFactory {

  @Override
  public Member create(@NonNull OAuth2Member oAuth2Member) {
    return Member.builder()
        .email(oAuth2Member.email())
        .birthday(birthday(oAuth2Member.birthyear(), oAuth2Member.birthday()))
        .nickname(oAuth2Member.nickname())
        .name(oAuth2Member.name())
        .ageRange(AgeRange.fromNaverString(oAuth2Member.ageRange()))
        .phoneNo(oAuth2Member.phoneNo())
        .build();
  }

  private LocalDate birthday(@NonNull String birthyear, String birthday) {
    val YYYYMMDD = "yyyyMM-dd";

    if (birthday == null) {
      return (birthyear + "01-01").toLocalDate(YYYYMMDD);
    }
    return (birthyear + birthday).toLocalDate(YYYYMMDD);
  }
}
