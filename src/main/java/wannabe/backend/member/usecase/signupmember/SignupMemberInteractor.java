package wannabe.backend.member.usecase.signupmember;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wannabe.backend.member.entity.MemberId;
import wannabe.backend.member.usecase.oauth2integration.adapter.OAuth2Member;

@Service
@Transactional
@RequiredArgsConstructor
public class SignupMemberInteractor implements SignupMemberPort {

  private final SignupMemberDsGateway gateway;
  private final MemberFactoryProvider memberFactoryProvider;

  @Override
  public MemberId signup(@NonNull OAuth2Member oAuth2Member) {
    val memberFactory = memberFactoryProvider.getMemberFactory(oAuth2Member.provider());
    val saveMember = gateway.save(memberFactory.create(oAuth2Member));
    return saveMember.getId();
  }
}
