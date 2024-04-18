package wannabe.backend.core.member;

import lombok.NonNull;
import wannabe.backend.core.oauth2.adapter.OAuth2Member;

public interface MemberFactory {

  Member create(@NonNull OAuth2Member oAuth2Member);
}
