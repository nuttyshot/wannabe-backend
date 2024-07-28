package wannabe.backend.member.usecase.oauth2integration.adapter;

import lombok.NonNull;
import org.springframework.web.servlet.view.RedirectView;

public record OAuth2Response(@NonNull RedirectView redirectView) {

}
