package wannabe.backend.core.oauth2.adapter;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record OAuth2Request(@NonNull String registrationId,
                            @NonNull String code,
                            @NonNull String state) {

}
