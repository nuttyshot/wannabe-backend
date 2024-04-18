package wannabe.backend.core.oauth2.adapter;

import lombok.Builder;
import lombok.NonNull;
import wannabe.backend.core.oauth2.Provider;

@Builder
public record OAuth2Request(@NonNull Provider registrationId,
                            @NonNull String code,
                            @NonNull String state) {

}
