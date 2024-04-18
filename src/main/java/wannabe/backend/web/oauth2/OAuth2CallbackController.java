package wannabe.backend.web.oauth2;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wannabe.backend.core.oauth2.Provider;
import wannabe.backend.core.oauth2.adapter.OAuth2Adapter;
import wannabe.backend.core.oauth2.adapter.OAuth2Request;

@RestController
@RequestMapping("/login/oauth2/code/{providerId}")
@RequiredArgsConstructor
public class OAuth2CallbackController {

  private final OAuth2Adapter oAuth2Adapter;

  /**
   * OAuth2 성공 후 Resource Server 로 부터 받은 사용자 정보를 쿠키에 담은 후 적절한 곳으로 redirect 시킨다.
   */
  @GetMapping
  public void success(
      @RequestParam(value = "code") String code,
      @RequestParam(value = "state") String state,
      HttpServletResponse response) throws IOException {

    val registrationId = state.split(",")[0];

    val oAuth2Request = OAuth2Request.builder()
        .registrationId(Provider.valueOf(registrationId))
        .code(code)
        .state(state)
        .build();

    val oAuth2Response = oAuth2Adapter.success(oAuth2Request);
    response.sendRedirect(oAuth2Response.redirectView().getUrl());
  }
}
