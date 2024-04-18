package wannabe.backend.core.oauth2.adapter;

import lombok.Builder;
import lombok.NonNull;
import wannabe.backend.core.oauth2.Provider;

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
