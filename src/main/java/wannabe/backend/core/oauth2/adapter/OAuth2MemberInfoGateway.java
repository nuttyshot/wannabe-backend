package wannabe.backend.core.oauth2.adapter;

import lombok.NonNull;
import wannabe.backend.core.oauth2.Provider;

public interface OAuth2MemberInfoGateway {

  OAuth2Member resolve(@NonNull OAuth2Request request);

  String accessToken(@NonNull Provider registrationId, @NonNull String code, @NonNull String state);
}
