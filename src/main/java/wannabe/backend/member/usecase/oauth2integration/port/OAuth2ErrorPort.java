package wannabe.backend.member.usecase.oauth2integration.port;

import java.util.Map;
import lombok.NonNull;
import wannabe.backend.member.usecase.oauth2integration.Provider;

public interface OAuth2ErrorPort {

  void receive(@NonNull Provider registrationId, int status, @NonNull Map<String, Object> resBody);
}
