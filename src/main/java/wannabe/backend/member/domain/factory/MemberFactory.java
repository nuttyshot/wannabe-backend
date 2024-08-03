package wannabe.backend.member.domain.factory;

import lombok.NonNull;
import wannabe.backend.member.domain.Member;
import wannabe.backend.member.domain.OAuth2Member;

public interface MemberFactory {

  Member create(@NonNull OAuth2Member oAuth2Member);
}
