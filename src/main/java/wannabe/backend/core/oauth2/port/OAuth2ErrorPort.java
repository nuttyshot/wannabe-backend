package wannabe.backend.core.oauth2.port;

import java.util.Map;
import lombok.NonNull;
import wannabe.backend.core.oauth2.Provider;

public interface OAuth2ErrorPort {

  void receive(@NonNull Provider registrationId, int status, @NonNull Map<String, Object> resBody);
}
