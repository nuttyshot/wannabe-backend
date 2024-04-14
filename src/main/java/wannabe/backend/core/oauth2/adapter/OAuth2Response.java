package wannabe.backend.core.oauth2.adapter;

import lombok.NonNull;
import org.springframework.web.servlet.view.RedirectView;

public record OAuth2Response(@NonNull RedirectView redirectView) {

}
