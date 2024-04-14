package wannabe.backend.core.oauth2.port;

import java.util.Map;
import lombok.NonNull;

public interface OAuth2ErrorPort {

  void receive(@NonNull String registrationId, int status, @NonNull Map<String, Object> resBody);
}
