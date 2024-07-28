package wannabe.backend.member.usecase.oauth2integration.adapter;

import lombok.NonNull;

public interface OAuth2Adapter {

  OAuth2Response success(@NonNull OAuth2Request request);
}
