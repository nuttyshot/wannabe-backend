package wannabe.backend.oauth2.usecase;

import lombok.NonNull;
import wannabe.backend.member.domain.OAuth2Request;
import wannabe.backend.member.domain.OAuth2Response;

public interface OAuth2RedirectUseCase {

  OAuth2Response success(@NonNull OAuth2Request request);
}
