package wannabe.backend.member.usecase.signupmember;

import java.time.LocalDate;
import lombok.NonNull;
import lombok.experimental.ExtensionMethod;
import lombok.val;
import org.springframework.stereotype.Service;
import wannabe.backend.member.usecase.findmember.AgeRange;
import wannabe.backend.util.date.DateExtension;
import wannabe.backend.infrastructure.member.Member;
import wannabe.backend.member.usecase.oauth2integration.adapter.OAuth2Member;

@ExtensionMethod(DateExtension.class)
@Service
public class KakaoMemberFactory implements MemberFactory {

  @Override
  public Member create(@NonNull OAuth2Member oAuth2Member) {
    return Member.builder()
        .email(oAuth2Member.email())
        .birthday(birthday(oAuth2Member.birthyear(), oAuth2Member.birthday()))
        .nickname(oAuth2Member.nickname())
        .name(oAuth2Member.name())
        .ageRange(AgeRange.fromKakaoString(oAuth2Member.ageRange()))
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
