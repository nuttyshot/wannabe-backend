package wannabe.backend.token.domain;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record LoginToken(@NonNull String accessToken,
                         @NonNull String refreshToken,
                         long expiredAt) {

}
