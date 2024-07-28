package wannabe.backend.member.usecase.oauth2integration;

import lombok.NonNull;
import wannabe.backend.member.usecase.oauth2integration.adapter.OAuth2Response;

public interface OAuth2Presenter {

  OAuth2Response mainPage(@NonNull String accessToken, @NonNull String refreshToken,
      long expiredAt);
}
