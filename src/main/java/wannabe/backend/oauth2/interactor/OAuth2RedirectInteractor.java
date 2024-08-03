package wannabe.backend.oauth2.interactor;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import wannabe.backend.member.domain.MemberId;
import wannabe.backend.member.usecase.FindMemberUseCase;
import wannabe.backend.oauth2.usecase.OAuth2RedirectUseCase;
import wannabe.backend.member.presenter.OAuth2Presenter;
import wannabe.backend.member.domain.OAuth2Member;
import wannabe.backend.oauth2.usecase.GetOAuth2MemberInfoUseCase;
import wannabe.backend.member.domain.OAuth2Request;
import wannabe.backend.member.domain.OAuth2Response;
import wannabe.backend.member.usecase.SignupMemberPort;
import wannabe.backend.token.usecase.getlogintoken.TokenInformation;
import wannabe.backend.token.usecase.getlogintoken.LoginTokenPort;

@Service
@RequiredArgsConstructor
public class OAuth2RedirectInteractor implements OAuth2RedirectUseCase {

  private final GetOAuth2MemberInfoUseCase getOAuth2MemberInfoUseCase;
  private final FindMemberUseCase findMemberUseCase;
  private final SignupMemberPort signupMemberPort;
  private final OAuth2Presenter presenter;
  private final LoginTokenPort loginTokenPort;

  @Override
  public OAuth2Response success(@NonNull OAuth2Request request) {
    val oAuth2Member = getOAuth2MemberInfoUseCase.resolve(request);
    val member = findMemberUseCase.findByEmail(oAuth2Member.email());

    if (member.isEmpty()) {
      return signup(oAuth2Member);
    }
    return joined(member.get().getId());
  }

  private OAuth2Response signup(@NonNull OAuth2Member oAuth2Member) {
    val id = signupMemberPort.signup(oAuth2Member);
    return mainPage(id);
  }

  private OAuth2Response joined(@NonNull MemberId id) {
    return mainPage(id);
  }

  private OAuth2Response mainPage(@NonNull MemberId id) {
    val loginToken = loginTokenPort.getLoginToken(new TokenInformation(id.id()));
    return presenter.mainPage(loginToken.accessToken(), loginToken.refreshToken(), loginToken.expiredAt());
  }
}
