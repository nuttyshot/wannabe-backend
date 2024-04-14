package wannabe.backend.config.security.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtClaimer implements JwtGateway {

  private final JwtSecurityArgumentGateway jwtSecurityArgumentGateway;

  @Override
  public Claims extractClaims(@NonNull String token) {
    val key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecurityArgumentGateway.jwtSecret()));

    try {
      return Jwts.parserBuilder()
          .setSigningKey(key)
          .build()
          .parseClaimsJws(token)
          .getBody();
    } catch (SecurityException | MalformedJwtException | SignatureException e) {
      throw new JwtClaimerException("잘못된 JWT 서명입니다.", e, "INVALID_JWT_SIGNATURE");
    } catch (ExpiredJwtException e) {
      throw new JwtClaimerException("만료된 JWT 서명입니다.", e, "EXPIRED_JWT_TOKEN");
    } catch (UnsupportedJwtException e) {
      throw new JwtClaimerException("지원하지 않는 JWT 토큰입니다.", e, "UNSUPPORTED_JWT_TOKEN");
    } catch (IllegalArgumentException e) {
      throw new JwtClaimerException("JWT 토큰이 잘못되었습니다.", e, "INVALID_JWT_TOKEN");
    }
  }
}
