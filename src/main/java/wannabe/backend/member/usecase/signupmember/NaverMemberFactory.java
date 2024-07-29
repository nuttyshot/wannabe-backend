package wannabe.backend.member.usecase.signupmember;

import java.time.LocalDate;
import lombok.NonNull;
import lombok.experimental.ExtensionMethod;
import lombok.val;
import org.springframework.stereotype.Service;
import wannabe.backend.member.entity.Member;
import wannabe.backend.member.entity.MemberBirthday;
import wannabe.backend.member.entity.MemberEmail;
import wannabe.backend.member.entity.MemberFactory;
import wannabe.backend.member.entity.MemberName;
import wannabe.backend.member.entity.Nickname;
import wannabe.backend.member.usecase.findmember.AgeRange;
import wannabe.backend.member.usecase.oauth2integration.adapter.OAuth2Member;
import wannabe.backend.util.date.DateExtension;

@ExtensionMethod(DateExtension.class)
@Service
public class NaverMemberFactory implements MemberFactory {

  @Override
  public Member create(@NonNull OAuth2Member oAuth2Member) {
    return Member.builder()
        .email(new MemberEmail(oAuth2Member.email()))
        .birthday(new MemberBirthday(birthday(oAuth2Member.birthyear(), oAuth2Member.birthday())))
        .nickname(new Nickname(oAuth2Member.nickname()))
        .name(new MemberName(oAuth2Member.name()))
        .ageRange(AgeRange.fromNaverString(oAuth2Member.ageRange()))
        .provider(Provider.NAVER)
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
