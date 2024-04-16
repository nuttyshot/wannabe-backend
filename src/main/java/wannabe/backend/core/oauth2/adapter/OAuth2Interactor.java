package wannabe.backend.core.oauth2.adapter;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import wannabe.backend.core.finduser.FindMemberPort;
import wannabe.backend.core.oauth2.OAuth2Presenter;
import wannabe.backend.core.signupmember.SignupMemberPort;
import wannabe.backend.core.token.TokenInformation;
import wannabe.backend.core.token.LoginTokenPort;

@Service
@RequiredArgsConstructor
public class OAuth2Interactor implements OAuth2Adapter {

  private final OAuth2MemberInfoGateway oAuth2MemberInfoGateway;
  private final FindMemberPort findMemberPort;
  private final SignupMemberPort signupMemberPort;
  private final OAuth2Presenter presenter;
  private final LoginTokenPort loginTokenPort;

  @Override
  public OAuth2Response success(@NonNull OAuth2Request request) {
    val oAuth2Member = oAuth2MemberInfoGateway.resolve(request);
    val member = findMemberPort.findByEmail(oAuth2Member.email());

    if (member.isEmpty()) {
      return signup(oAuth2Member);
    }
    return joined(member.get().getId());
  }

  private OAuth2Response signup(@NonNull OAuth2Member oAuth2Member) {
    val id = signupMemberPort.signup(oAuth2Member);
    return mainPage(id);
  }

  private OAuth2Response joined(long id) {
    return mainPage(id);
  }

  private OAuth2Response mainPage(long id) {
    val loginToken = loginTokenPort.getLoginToken(new TokenInformation(id));
    return presenter.mainPage(loginToken.accessToken(), loginToken.refreshToken(), loginToken.expiredAt());
  }
}
