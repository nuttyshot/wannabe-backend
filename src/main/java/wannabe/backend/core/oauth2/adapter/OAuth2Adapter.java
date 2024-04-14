package wannabe.backend.core.oauth2.adapter;

import lombok.NonNull;

public interface OAuth2Adapter {

  OAuth2Response success(@NonNull OAuth2Request request);
}
