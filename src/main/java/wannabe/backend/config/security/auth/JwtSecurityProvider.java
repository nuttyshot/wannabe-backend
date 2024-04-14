package wannabe.backend.config.security.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtSecurityProvider implements JwtSecurityArgumentGateway {

  @Value("${jwt.secret}")
  String jwtSecret;

  @Override
  public String jwtSecret() {
    return jwtSecret;
  }
}
