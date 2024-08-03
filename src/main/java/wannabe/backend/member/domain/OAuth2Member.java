package wannabe.backend.member.domain;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record OAuth2Member(@NonNull Provider provider,
                           @NonNull String email,
                           @NonNull String birthyear,
                           String nickname,
                           String name,
                           String ageRange,
                           String birthday,
                           String phoneNo) {

}
