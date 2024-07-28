package wannabe.backend.member.usecase.oauth2integration.adapter;

import lombok.NonNull;
import wannabe.backend.member.usecase.oauth2integration.Provider;

public interface OAuth2MemberInfoGateway {

  OAuth2Member resolve(@NonNull OAuth2Request request);

  String accessToken(@NonNull Provider registrationId, @NonNull String code, @NonNull String state);
}
