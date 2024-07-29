package wannabe.backend.token.usecase.getlogintoken;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.util.Collections;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import wannabe.backend.config.security.auth.JwtSecurityArgumentGateway;
import wannabe.backend.token.usecase.getlogintoken.TokenInformation.TokenKey;
import wannabe.backend.util.date.DateTimeProvider;

@Service
@RequiredArgsConstructor
public class RefreshTokenInteractor implements RefreshTokenPort {

  private final JwtSecurityArgumentGateway jwtSecurityArgumentGateway;
  private final AuthenticationManagerBuilder authenticationManagerBuilder;
  private final DateTimeProvider dateTimeProvider;

  @Override
  public String getRefreshToken(@NonNull TokenInformation tokenInformation, @NonNull String issuer) {
    val key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecurityArgumentGateway.jwtSecret()));

    val now = dateTimeProvider.nowTimestamp();
    val uuid = UUID.randomUUID().toString();
    val REFRESH_TOKEN_EXPIRATION_TIME = 1000L * 60 * 60 * 24 * 30 * 3; // 3개월

    // MEMBER ID를 기반으로 Authentication 객체 생성
    val authenticationToken = new UsernamePasswordAuthenticationToken(
        tokenInformation.memberId(), "", Collections.emptyList());
    val authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

    // 권한 목록 가져오기
    val authorities = authentication.getAuthorities().stream()
        .map(GrantedAuthority::getAuthority)
        .collect(Collectors.joining(","));

    return Jwts.builder()
        .claim(TokenKey.MEMBER_ID_KEY.getValue(), tokenInformation.memberId())
        .claim("auth", authorities)
        .signWith(key, SignatureAlgorithm.HS512)
        .setSubject(uuid)
        .setIssuer(issuer)
        .setIssuedAt(new Date(now))
        .setNotBefore(new Date(now))
        .setExpiration(new Date(now + REFRESH_TOKEN_EXPIRATION_TIME))
        .setId(uuid)
        .compact();
  }
}
