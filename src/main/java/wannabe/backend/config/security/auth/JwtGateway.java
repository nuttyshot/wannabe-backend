package wannabe.backend.config.security.auth;

import io.jsonwebtoken.Claims;
import lombok.NonNull;

public interface JwtGateway {

  Claims extractClaims(@NonNull String token);
}
