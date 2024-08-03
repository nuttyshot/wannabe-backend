package wannabe.backend.member.domain.factory;

import java.time.LocalDate;
import lombok.NonNull;
import lombok.experimental.ExtensionMethod;
import lombok.val;
import org.springframework.stereotype.Service;
import wannabe.backend.member.domain.Member;
import wannabe.backend.member.domain.MemberBirthday;
import wannabe.backend.member.domain.MemberEmail;
import wannabe.backend.member.domain.MemberName;
import wannabe.backend.member.domain.Nickname;
import wannabe.backend.member.domain.AgeRange;
import wannabe.backend.member.domain.OAuth2Member;
import wannabe.backend.member.domain.Provider;
import wannabe.backend.util.date.DateExtension;

@ExtensionMethod(DateExtension.class)
@Service
public class KakaoMemberFactory implements MemberFactory {

  @Override
  public Member create(@NonNull OAuth2Member oAuth2Member) {
    return Member.builder()
        .email(new MemberEmail(oAuth2Member.email()))
        .birthday(new MemberBirthday(birthday(oAuth2Member.birthyear(), oAuth2Member.birthday())))
        .nickname(new Nickname(oAuth2Member.nickname()))
        .name(new MemberName(oAuth2Member.name()))
        .ageRange(AgeRange.fromKakaoString(oAuth2Member.ageRange()))
        .provider(Provider.KAKAO)
        .build();
  }

  private LocalDate birthday(@NonNull String birthyear, String birthday) {
    val YYYYMMDD = "yyyyMMdd";

    if (birthday == null) {
      return (birthyear + "0101").toLocalDate(YYYYMMDD);
    }
    return (birthyear + birthday).toLocalDate(YYYYMMDD);
  }
}
