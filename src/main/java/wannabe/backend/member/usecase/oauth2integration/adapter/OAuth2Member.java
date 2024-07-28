package wannabe.backend.member.usecase.oauth2integration.adapter;

import lombok.Builder;
import lombok.NonNull;
import wannabe.backend.member.usecase.oauth2integration.Provider;

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
