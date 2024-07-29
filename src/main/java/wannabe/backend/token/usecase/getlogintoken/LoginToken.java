package wannabe.backend.token.usecase.getlogintoken;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NonNull;

@Builder(access = AccessLevel.PACKAGE)
public record LoginToken(@NonNull String accessToken,
                         @NonNull String refreshToken,
                         long expiredAt) {

}
