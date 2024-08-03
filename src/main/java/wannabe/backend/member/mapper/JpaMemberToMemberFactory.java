package wannabe.backend.member.mapper;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import wannabe.backend.member.repository.JpaMember;
import wannabe.backend.member.domain.Member;
import wannabe.backend.member.domain.MemberBirthday;
import wannabe.backend.member.domain.MemberEmail;
import wannabe.backend.member.domain.MemberId;
import wannabe.backend.member.domain.MemberName;
import wannabe.backend.member.domain.Nickname;

@Service
public class JpaMemberToMemberFactory {

  public static Member create(@NonNull JpaMember member) {
    return Member.builder()
        .id(new MemberId(member.getId()))
        .email(new MemberEmail(member.getEmail()))
        .birthday(new MemberBirthday(member.getBirthday()))
        .nickname(new Nickname(member.getNickname()))
        .name(new MemberName(member.getName()))
        .ageRange(member.getAgeRange())
        .provider(member.getProvider())
        .build();
  }
}
