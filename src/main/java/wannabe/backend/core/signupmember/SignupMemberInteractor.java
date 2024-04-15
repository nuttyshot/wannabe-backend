package wannabe.backend.core.signupmember;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wannabe.backend.core.oauth2.adapter.OAuth2Member;

@Service
@Transactional
public class SignupMemberInteractor implements SignupMemberPort {

  @Override
  public void signup(@NonNull OAuth2Member oAuth2Member) {
  }
}
