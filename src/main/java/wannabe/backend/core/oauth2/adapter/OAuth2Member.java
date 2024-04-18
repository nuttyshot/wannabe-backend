package wannabe.backend.core.oauth2.adapter;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record OAuth2Member(@NonNull String provider,
                           @NonNull String email,
                           @NonNull String birthyear,
                           String nickname,
                           String name,
                           String ageRange,
                           String birthday,
                           String phoneNo) {

}
