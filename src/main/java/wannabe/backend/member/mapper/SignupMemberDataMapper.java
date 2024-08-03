package wannabe.backend.member.mapper;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import wannabe.backend.member.repository.MemberEntity;
import wannabe.backend.member.repository.MemberRepository;
import wannabe.backend.member.domain.Member;
import wannabe.backend.member.gateway.SignupMemberDsGateway;

@Service
@RequiredArgsConstructor
public class SignupMemberDataMapper implements SignupMemberDsGateway {

  private final MemberRepository repository;

  @Override
  public Member save(@NonNull Member member) {
    val savedMember = repository.save(MemberEntity.builder()
        .email(member.getEmail().getEmail())
        .birthday(member.getBirthday().getBirthday())
        .nickname(member.getNickname().getNickname())
        .name(member.getName().getName())
        .ageRange(member.getAgeRange())
        .provider(member.getProvider())
        .build());
    return MemberEntityToMemberMapper.create(savedMember);
  }
}
