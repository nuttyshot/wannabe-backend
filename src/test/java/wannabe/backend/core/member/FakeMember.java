package wannabe.backend.core.member;

import static wannabe.backend.core.member.Provider.*;

import java.time.LocalDate;
import lombok.Builder;
import lombok.NonNull;
import lombok.With;
import wannabe.backend.core.finduser.AgeRange;

@With
@Builder
public record FakeMember(
    Long id,
    @NonNull String email,
    LocalDate birthday,
    String nickname,
    String name,
    AgeRange ageRange,
    Provider provider) {

  public Member toMember() {
    return Member.builder()
        .id(id)
        .email(email)
        .birthday(birthday)
        .nickname(nickname)
        .name(name)
        .ageRange(ageRange)
        .provider(provider)
        .build();
  }
}
