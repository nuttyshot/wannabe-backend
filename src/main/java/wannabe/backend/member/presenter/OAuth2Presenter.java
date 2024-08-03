package wannabe.backend.member.presenter;

import lombok.NonNull;
import wannabe.backend.member.domain.OAuth2Response;

public interface OAuth2Presenter {

  OAuth2Response mainPage(@NonNull String accessToken, @NonNull String refreshToken,
      long expiredAt);
}
