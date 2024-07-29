package wannabe.backend.infrastructure.member;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import wannabe.backend.member.entity.Member;
import wannabe.backend.member.entity.MemberBirthday;
import wannabe.backend.member.entity.MemberEmail;
import wannabe.backend.member.entity.MemberId;
import wannabe.backend.member.entity.MemberName;
import wannabe.backend.member.entity.Nickname;

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
