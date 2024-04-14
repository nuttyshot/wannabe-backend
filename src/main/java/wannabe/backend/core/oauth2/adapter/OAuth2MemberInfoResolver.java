package wannabe.backend.core.oauth2.adapter;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OAuth2MemberInfoResolver implements OAuth2MemberInfoGateway {

  @Override
  public OAuth2Member resolve(@NonNull OAuth2Request request) {
    return null;
  }

  @Override
  public String accessToken(@NonNull String registrationId, @NonNull String code,
      @NonNull String state) {
    return "";
  }
}
