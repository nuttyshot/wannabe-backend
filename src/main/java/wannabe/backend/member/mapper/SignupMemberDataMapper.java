package wannabe.backend.member.mapper;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import wannabe.backend.member.repository.JpaMember;
import wannabe.backend.member.repository.JpaMemberRepository;
import wannabe.backend.member.domain.Member;
import wannabe.backend.member.gateway.SignupMemberDsGateway;

@Service
@RequiredArgsConstructor
public class SignupMemberDataMapper implements SignupMemberDsGateway {

  private final JpaMemberRepository repository;

  @Override
  public Member save(@NonNull Member member) {
    val savedMember = repository.save(JpaMember.builder()
        .email(member.getEmail().getEmail())
        .birthday(member.getBirthday().getBirthday())
        .nickname(member.getNickname().getNickname())
        .name(member.getName().getName())
        .ageRange(member.getAgeRange())
        .provider(member.getProvider())
        .build());
    return JpaMemberToMemberFactory.create(savedMember);
  }
}
