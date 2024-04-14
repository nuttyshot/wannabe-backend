package wannabe.backend.core.oauth2.adapter;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OAuth2Interactor implements OAuth2Adapter {

  private final OAuth2MemberInfoGateway oAuth2MemberInfoGateway;

  @Override
  public OAuth2Response success(@NonNull OAuth2Request request) {
    return null;
  }
}
