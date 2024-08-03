package wannabe.backend.oauth2.usecase;

import java.util.Map;
import lombok.NonNull;
import wannabe.backend.member.domain.Provider;

public interface ValidateOAuth2ErrorUseCase {

  void execute(@NonNull Provider registrationId, int status, @NonNull Map<String, Object> resBody);
}
