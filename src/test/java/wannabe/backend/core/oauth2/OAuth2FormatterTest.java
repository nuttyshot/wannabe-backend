package wannabe.backend.core.oauth2;

import static java.nio.charset.StandardCharsets.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.net.URLEncoder;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import wannabe.backend.member.usecase.oauth2integration.OAuth2Formatter;
import wannabe.backend.member.usecase.oauth2integration.redirectpages.FrontBaseUrlArgumentGateway;

@ExtendWith(MockitoExtension.class)
class OAuth2FormatterTest {

  @InjectMocks
  private OAuth2Formatter formatter;

  @Mock
  private FrontBaseUrlArgumentGateway frontBaseUrlArgumentGateway;

  @Test
  void 메인_페이지_access_refresh_token과_member_정보가_포함되어야한다() {
    // given
    when(frontBaseUrlArgumentGateway.mobile()).thenReturn("MOCK_FRONT_MOBILE_URL");
    // when
    val response = formatter.mainPage("MOCK_ACCESS_TOKEN", "MOCK_REFRESH_TOKEN", 0L);
    // then
    assertThat(response.redirectView().getUrl())
        .contains(URLEncoder.encode("access-token", UTF_8))
        .contains(URLEncoder.encode("&refresh-token", UTF_8))
        .contains(URLEncoder.encode("&expired-at", UTF_8));
  }
}