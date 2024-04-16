package wannabe.backend.core.token;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.INSTANT;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import io.jsonwebtoken.Jwts;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import wannabe.backend.config.security.auth.JwtSecurityArgumentGateway;
import wannabe.backend.core.token.TokenInformation.TokenKey;

@ExtendWith(MockitoExtension.class)
class AccessTokenInteractorTest {

  @InjectMocks
  private AccessTokenInteractor interactor;

  @Mock
  private JwtSecurityArgumentGateway jwtSecurityArgumentGateway;

  @Mock
  private AuthenticationManagerBuilder authenticationManagerBuilder;

  @Test
  void 액세스_토큰을_생성한다() {
    // given
    val KEY = over256Bit();
    // Keys.hmacShaKeyFor 에서 256 비트 이상 넘겨야함
    when(jwtSecurityArgumentGateway.jwtSecret()).thenReturn(KEY);
    val authenticationManager = mock(AuthenticationManager.class);
    when(authenticationManagerBuilder.getObject()).thenReturn(authenticationManager);
    when(authenticationManager.authenticate(any())).thenReturn(mock(Authentication.class));
    // when
    val accessToken = interactor.getAccessToken(new TokenInformation(1L), "MOCK_ISSUER",
        "MOCK_UUID", 1000L, Instant.now().toEpochMilli());

    // then
    val parseToken = Jwts.parserBuilder()
        .setSigningKey(KEY)
        .build()
        .parseClaimsJws(accessToken)
        .getBody();
    assertThat(parseToken.get(TokenKey.MEMBER_ID_KEY.getValue())).isEqualTo(1);
  }

  private String over256Bit() {
    val secret = "SECRET";
    return secret.repeat(45);
  }
}