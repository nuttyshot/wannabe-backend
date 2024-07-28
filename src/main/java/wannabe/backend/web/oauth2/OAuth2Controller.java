package wannabe.backend.web.oauth2;

import io.swagger.v3.oas.annotations.Hidden;
import java.util.UUID;
import javax.naming.OperationNotSupportedException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import wannabe.backend.member.usecase.oauth2integration.OAuth2ArgumentChooserService;
import wannabe.backend.member.usecase.oauth2integration.Provider;

@Hidden
@RestController
@RequestMapping("/oauth2/authorization")
@RequiredArgsConstructor
public class OAuth2Controller {

  private final OAuth2ArgumentChooserService chooser;

  @GetMapping("/kakao")
  public RedirectView kakao() {
    return new RedirectView(redirectUri(Provider.KAKAO));
  }

  @GetMapping("/naver")
  public RedirectView naver() {
    return new RedirectView(redirectUri(Provider.NAVER));
  }

  private String redirectUri(@NonNull Provider registrationId) {
    try {
      val argumentPort = chooser.choose(registrationId);
      return String.format("%s?response_type=%s&client_id=%s&state=%s&redirect_uri=%s&scope=%s",
          argumentPort.client().provider().authorizationUri(),
          argumentPort.client().registration().authorizationResponseType(),
          argumentPort.client().registration().clientId(),
          state(registrationId),
          argumentPort.client().registration().redirectUri(),
          argumentPort.client().registration().scope().stream().reduce((a, b) -> a + "," + b).get()
      );
    } catch (OperationNotSupportedException e) {
      throw new IllegalArgumentException(e);
    }
  }

  private String state(@NonNull Provider registrationId) {
    return String.format("%s,%s", registrationId, UUID.randomUUID());
  }
}
