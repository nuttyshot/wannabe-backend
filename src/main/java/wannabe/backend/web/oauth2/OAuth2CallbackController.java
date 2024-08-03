package wannabe.backend.web.oauth2;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wannabe.backend.member.domain.Provider;
import wannabe.backend.oauth2.usecase.OAuth2RedirectUseCase;
import wannabe.backend.member.domain.OAuth2Request;

@Hidden
@RestController
@RequestMapping("/login/oauth2/code/{providerId}")
@RequiredArgsConstructor
public class OAuth2CallbackController {

  private final OAuth2RedirectUseCase oAuth2RedirectUseCase;

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

    val oAuth2Response = oAuth2RedirectUseCase.execute(oAuth2Request);
    response.sendRedirect(oAuth2Response.redirectView().getUrl());
  }
}
