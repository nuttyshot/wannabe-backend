package wannabe.backend.member.usecase;

import lombok.NonNull;
import wannabe.backend.member.domain.MemberId;
import wannabe.backend.member.domain.OAuth2Member;

public interface SignupMemberPort {

  MemberId signup(@NonNull OAuth2Member oAuth2Member);
}
