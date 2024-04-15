package wannabe.backend.core.oauth2.adapter;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;
import wannabe.backend.core.finduser.FindMemberPort;
import wannabe.backend.core.oauth2.OAuth2Presenter;
import wannabe.backend.core.signupmember.SignupMemberPort;

@Service
@RequiredArgsConstructor
public class OAuth2Interactor implements OAuth2Adapter {

  private final OAuth2MemberInfoGateway oAuth2MemberInfoGateway;
  private final FindMemberPort findMemberPort;
  private final SignupMemberPort signupMemberPort;

  @Override
  public OAuth2Response success(@NonNull OAuth2Request request) {
    val oAuth2Member = oAuth2MemberInfoGateway.resolve(request);
    val member = findMemberPort.findByEmail(oAuth2Member.email());

    if (member.isEmpty()) {
      return signup(oAuth2Member);
    }
    return joined();
  }

  private OAuth2Response signup(@NonNull OAuth2Member oAuth2Member) {
    signupMemberPort.signup(oAuth2Member);
    return null;
  }

  private OAuth2Response joined() {
    return null;
  }
}
