package wannabe.backend.member.usecase.signupmember;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wannabe.backend.infrastructure.member.MemberRepository;
import wannabe.backend.member.usecase.oauth2integration.adapter.OAuth2Member;

@Service
@Transactional
@RequiredArgsConstructor
public class SignupMemberInteractor implements SignupMemberPort {

  private final MemberRepository memberRepository;
  private final MemberFactoryProvider memberFactoryProvider;

  @Override
  public long signup(@NonNull OAuth2Member oAuth2Member) {
    val memberFactory = memberFactoryProvider.getMemberFactory(oAuth2Member.provider());
    val saveMember = memberRepository.save(memberFactory.create(oAuth2Member));
    return saveMember.getId();
  }
}
