package wannabe.backend.member.usecase.signupmember;

import lombok.NonNull;
import wannabe.backend.member.usecase.oauth2integration.adapter.OAuth2Member;

public interface SignupMemberPort {

  long signup(@NonNull OAuth2Member oAuth2Member);
}
