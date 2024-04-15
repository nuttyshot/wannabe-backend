package wannabe.backend.core.oauth2;

import lombok.NonNull;
import wannabe.backend.core.oauth2.adapter.OAuth2Response;

public interface OAuth2Presenter {

  OAuth2Response mainPage(@NonNull String accessToken, @NonNull String refreshToken,
      long expiredAt);
}
