package wannabe.backend.core.signupmember;

import static wannabe.backend.core.oauth2.Provider.*;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wannabe.backend.core.member.MemberFactory;
import wannabe.backend.core.member.MemberRepository;
import wannabe.backend.core.oauth2.Provider;
import wannabe.backend.core.oauth2.adapter.OAuth2Member;

@Service
@Transactional
@RequiredArgsConstructor
public class SignupMemberInteractor implements SignupMemberPort {

  private final MemberRepository memberRepository;
  private final MemberFactory kakaoMemberFactory;
  private final MemberFactory naverMemberFactory;

  @Override
  public long signup(@NonNull OAuth2Member oAuth2Member) {
    val memberFactory = getMemberFactory(oAuth2Member.provider());
    val saveMember = memberRepository.save(memberFactory.create(oAuth2Member));
    return saveMember.getId();
  }

  private MemberFactory getMemberFactory(@NonNull Provider provider) {
    if (KAKAO == provider) {
      return kakaoMemberFactory;
    }
    if (NAVER == provider) {
      return naverMemberFactory;
    }
    throw new IllegalArgumentException(provider + "는 지원하지 않습니다.");
  }
}
