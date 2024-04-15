package wannabe.backend.core.signupmember;

import lombok.NonNull;
import wannabe.backend.core.oauth2.adapter.OAuth2Member;

public interface SignupMemberPort {

  void signup(@NonNull OAuth2Member oAuth2Member);
}
