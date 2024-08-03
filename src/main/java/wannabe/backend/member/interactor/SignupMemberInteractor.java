package wannabe.backend.member.interactor;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wannabe.backend.member.domain.MemberId;
import wannabe.backend.member.domain.OAuth2Member;
import wannabe.backend.member.domain.factory.MemberFactoryProvider;
import wannabe.backend.member.gateway.SignupMemberDsGateway;
import wannabe.backend.member.usecase.SignupMemberPort;

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
