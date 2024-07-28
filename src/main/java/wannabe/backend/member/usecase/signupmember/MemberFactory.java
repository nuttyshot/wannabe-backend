package wannabe.backend.member.usecase.signupmember;

import lombok.NonNull;
import wannabe.backend.infrastructure.member.Member;
import wannabe.backend.member.usecase.oauth2integration.adapter.OAuth2Member;

public interface MemberFactory {

  Member create(@NonNull OAuth2Member oAuth2Member);
}
