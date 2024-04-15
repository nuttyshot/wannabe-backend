package wannabe.backend.core.signupmember;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wannabe.backend.core.member.MemberFactory;
import wannabe.backend.core.member.MemberRepository;
import wannabe.backend.core.oauth2.adapter.OAuth2Member;

@Service
@Transactional
@RequiredArgsConstructor
public class SignupMemberInteractor implements SignupMemberPort {

  private final MemberRepository memberRepository;
  private final MemberFactory memberFactory;

  @Override
  public long signup(@NonNull OAuth2Member oAuth2Member) {
    val saveMember = memberRepository.save(memberFactory.create(oAuth2Member));
    return saveMember.getId();
  }
}
