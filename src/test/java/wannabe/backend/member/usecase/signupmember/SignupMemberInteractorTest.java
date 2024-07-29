package wannabe.backend.member.usecase.signupmember;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import wannabe.backend.infrastructure.member.Member;
import wannabe.backend.infrastructure.member.MemberRepository;
import wannabe.backend.member.usecase.oauth2integration.Provider;
import wannabe.backend.member.usecase.oauth2integration.adapter.OAuth2Member;

@ExtendWith(MockitoExtension.class)
class SignupMemberInteractorTest {

  @InjectMocks
  private SignupMemberInteractor interactor;

  @Mock
  private MemberRepository memberRepository;

  @Mock
  private MemberFactoryProvider memberFactoryProvider;

  @Mock
  private MemberFactory memberFactory;

  @Test
  void 회원가입() {
    // given
    when(memberFactoryProvider.getMemberFactory(any())).thenReturn(memberFactory);
    when(memberFactory.create(any())).thenReturn(FakeFactory.memberBeforeSave());
    when(memberRepository.save(any())).thenReturn(FakeFactory.memberAfterSave());
    // when
    interactor.signup(FakeFactory.oauth2Member());
    // then
    verify(memberFactoryProvider, only()).getMemberFactory(any());
    verify(memberFactory, only()).create(any());
    verify(memberRepository, only()).save(any());
  }

  private static class FakeFactory {

    private static Member memberBeforeSave() {
      return FakeMember.builder()
          .email("MOCK_EMAIL")
          .build()
          .toMember();
    }

    private static Member memberAfterSave() {
      return FakeMember.builder()
          .id(1L)
          .email("MOCK_EMAIL")
          .build()
          .toMember();
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