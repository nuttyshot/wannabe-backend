package wannabe.backend.web.oauth2;

import java.util.UUID;
import javax.naming.OperationNotSupportedException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import wannabe.backend.core.oauth2.OAuth2ArgumentChooserService;

@RestController
@RequestMapping("/oauth2/authorization")
@RequiredArgsConstructor
public class OAuth2Controller {

  private final OAuth2ArgumentChooserService chooser;

  @GetMapping("/kakao")
  public RedirectView kakao() {
    return new RedirectView(redirectUri("kakao"));
  }

  @GetMapping("/naver")
  public RedirectView naver() {
    return new RedirectView(redirectUri("naver"));
  }

  private String redirectUri(@NonNull String registrationId) {
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

  private String state(@NonNull String registrationId) {
    return String.format("%s,%s", registrationId, UUID.randomUUID());
  }
}
