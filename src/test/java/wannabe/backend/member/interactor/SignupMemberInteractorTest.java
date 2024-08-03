package wannabe.backend.member.interactor;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import wannabe.backend.member.domain.Member;
import wannabe.backend.member.domain.factory.MemberFactory;
import wannabe.backend.member.domain.MemberId;
import wannabe.backend.member.domain.Provider;
import wannabe.backend.member.domain.OAuth2Member;
import wannabe.backend.member.domain.factory.MemberFactoryProvider;
import wannabe.backend.member.gateway.SignupMemberDsGateway;

@ExtendWith(MockitoExtension.class)
class SignupMemberInteractorTest {

  @InjectMocks
  private SignupMemberInteractor interactor;

  @Mock
  private SignupMemberDsGateway gateway;

  @Mock
  private MemberFactoryProvider memberFactoryProvider;

  @Mock
  private MemberFactory memberFactory;

  @Test
  void 회원가입() {
    // given
    when(memberFactoryProvider.getMemberFactory(any())).thenReturn(memberFactory);
    when(memberFactory.create(any())).thenReturn(FakeFactory.memberBeforeSave());
    when(gateway.save(any())).thenReturn(FakeFactory.memberAfterSave());
    // when
    interactor.execute(FakeFactory.oauth2Member());
    // then
    verify(memberFactoryProvider, only()).getMemberFactory(any());
    verify(memberFactory, only()).create(any());
    verify(gateway, only()).save(any());
  }

  private static class FakeFactory {

    private static Member memberBeforeSave() {
      return Member.builder().build();
    }

    private static Member memberAfterSave() {
      return Member.builder()
          .id(new MemberId(1L))
          .build();
    }

    private static OAuth2Member oauth2Member() {
      return OAuth2Member.builder()
          .provider(Provider.KAKAO)
          .email("MOCK_EMAIL")
          .birthyear("MOCK_BIRTHYEAR")
          .build();
    }
  }
}