package wannabe.backend.member.domain;

import lombok.NonNull;
import org.springframework.web.servlet.view.RedirectView;

public record OAuth2Response(@NonNull RedirectView redirectView) {

}
