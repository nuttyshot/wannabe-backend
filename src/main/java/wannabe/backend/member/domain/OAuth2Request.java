package wannabe.backend.member.domain;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record OAuth2Request(@NonNull Provider registrationId,
                            @NonNull String code,
                            @NonNull String state) {

}
