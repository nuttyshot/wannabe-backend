package wannabe.backend.member.usecase.oauth2integration.adapter;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static wannabe.backend.member.usecase.oauth2integration.Provider.*;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import wannabe.backend.member.usecase.findmember.FindMemberPort;
import wannabe.backend.member.usecase.oauth2integration.OAuth2Presenter;
import wannabe.backend.member.usecase.signupmember.SignupMemberPort;
import wannabe.backend.token.usecase.getlogintoken.FakeLoginTokenFactory;
import wannabe.backend.token.usecase.getlogintoken.LoginTokenPort;

@ExtendWith(MockitoExtension.class)
class OAuth2InteractorTest {

  @InjectMocks
  private OAuth2Interactor interactor;

  @Mock
  private OAuth2MemberInfoGateway oAuth2MemberInfoGateway;

  @Mock
  private FindMemberPort findMemberPort;

  @Mock
  private SignupMemberPort signupMemberPort;

  @Mock
  private OAuth2Presenter presenter;

  @Mock
  private LoginTokenPort loginTokenPort;

  @Test
  void 가입한_유저가_아닐경우_가입시키고_페이지로_이동해야한다() {
    // given
    when(oAuth2MemberInfoGateway.resolve(any())).thenReturn(FakeOAuth2MemberFactory.nonMember());
    when(findMemberPort.findByEmail(anyString())).thenReturn(Optional.empty());
    when(loginTokenPort.getLoginToken(any())).thenReturn(FakeLoginTokenFactory.create());
    // when
    interactor.success(FakeOAuth2RequestFactory.create());
    // then
    verify(oAuth2MemberInfoGateway, only()).resolve(any());
    verify(findMemberPort, only()).findByEmail(anyString());
    verify(signupMemberPort, only()).signup(any());
    verify(loginTokenPort, only()).getLoginToken(any());
    verify(presenter, only()).mainPage(anyString(), anyString(), anyLong());
  }

  @Test
  void 기가입_유저일_경우_바로_페이지로_이동해야한다() {
    // given
    // when
    // then
  }

  private static class FakeOAuth2RequestFactory {

    private static OAuth2Request create() {
      return OAuth2Request.builder().registrationId(KAKAO).code("MOCK_CODE")
          .state("MOCK_STATE").build();
    }
  }

  private static class FakeOAuth2MemberFactory {

    private static OAuth2Member nonMember() {
      return OAuth2Member.builder()
          .provider(KAKAO)
          .email("MOCK_EMAIL")
          .birthyear("MOCK_BIRTHYEAR")
          .build();
    }
  }
}