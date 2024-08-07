package wannabe.backend.member.interactor;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static wannabe.backend.member.domain.Provider.KAKAO;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import wannabe.backend.member.domain.MemberId;
import wannabe.backend.member.domain.OAuth2Member;
import wannabe.backend.member.domain.OAuth2Request;
import wannabe.backend.oauth2.interactor.OAuth2RedirectInteractor;
import wannabe.backend.member.usecase.FindMemberUseCase;
import wannabe.backend.oauth2.usecase.GetOAuth2MemberInfoUseCase;
import wannabe.backend.member.presenter.OAuth2Presenter;
import wannabe.backend.member.usecase.SignupMemberUseCase;
import wannabe.backend.token.domain.FakeLoginTokenFactory;
import wannabe.backend.token.usecase.CreateLoginTokenUseCase;

@ExtendWith(MockitoExtension.class)
class OAuth2RedirectInteractorTest {

  @InjectMocks
  private OAuth2RedirectInteractor interactor;

  @Mock
  private GetOAuth2MemberInfoUseCase getOAuth2MemberInfoUseCase;

  @Mock
  private FindMemberUseCase findMemberUseCase;

  @Mock
  private SignupMemberUseCase signupMemberUseCase;

  @Mock
  private OAuth2Presenter presenter;

  @Mock
  private CreateLoginTokenUseCase createLoginTokenUseCAse;

  @Test
  void 가입한_유저가_아닐경우_가입시키고_페이지로_이동해야한다() {
    // given
    when(getOAuth2MemberInfoUseCase.resolve(any())).thenReturn(FakeOAuth2MemberFactory.nonMember());
    when(findMemberUseCase.execute(anyString())).thenReturn(Optional.empty());
    when(signupMemberUseCase.execute(any())).thenReturn(new MemberId(1L));
    when(createLoginTokenUseCAse.execute(any())).thenReturn(FakeLoginTokenFactory.create());
    // when
    interactor.execute(FakeOAuth2RequestFactory.create());
    // then
    verify(getOAuth2MemberInfoUseCase, only()).resolve(any());
    verify(findMemberUseCase, only()).execute(anyString());
    verify(signupMemberUseCase, only()).execute(any());
    verify(createLoginTokenUseCAse, only()).execute(any());
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