package wannabe.backend.oauth2.usecase;

import lombok.NonNull;
import wannabe.backend.member.domain.OAuth2Member;
import wannabe.backend.member.domain.Provider;
import wannabe.backend.member.domain.OAuth2Request;

public interface GetOAuth2MemberInfoUseCase {

  OAuth2Member resolve(@NonNull OAuth2Request request);

  String accessToken(@NonNull Provider registrationId, @NonNull String code, @NonNull String state);
}
