package wannabe.backend.core.oauth2;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;
import wannabe.backend.core.oauth2.adapter.OAuth2Response;
import wannabe.backend.core.oauth2.redirectpages.FrontBaseUrlArgumentGateway;

@Service
@RequiredArgsConstructor
public class OAuth2Formatter implements OAuth2Presenter {

  private final FrontBaseUrlArgumentGateway frontBaseUrlArgumentGateway;

  @Override
  public OAuth2Response mainPage(@NonNull String accessToken, @NonNull String refreshToken,
      long expiredAt) {

    val baseUrl = frontBaseUrlArgumentGateway.mobile();

    val queryParam = URLEncoder.encode(
        String.format("access-token=%s&refresh-token=%s&expired-at=%d", accessToken, refreshToken,
            expiredAt), StandardCharsets.UTF_8);

    val url = String.format("%s/main?%s", baseUrl, queryParam);

    return new OAuth2Response(new RedirectView(url));
  }
}
