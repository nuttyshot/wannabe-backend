package wannabe.backend.core.oauth2.adapter;

import lombok.NonNull;

public interface OAuth2MemberInfoGateway {

  OAuth2Member resolve(@NonNull OAuth2Request request);

  String accessToken(@NonNull String registrationId, @NonNull String code, @NonNull String state);
}
