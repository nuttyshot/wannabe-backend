package wannabe.backend.member.usecase.oauth2integration.adapter;

import lombok.Builder;
import lombok.NonNull;
import wannabe.backend.member.usecase.oauth2integration.Provider;

@Builder
public record OAuth2Request(@NonNull Provider registrationId,
                            @NonNull String code,
                            @NonNull String state) {

}
