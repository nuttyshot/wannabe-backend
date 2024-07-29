package wannabe.backend.member.entity;

import lombok.NonNull;
import wannabe.backend.member.usecase.oauth2integration.adapter.OAuth2Member;

public interface MemberFactory {

  Member create(@NonNull OAuth2Member oAuth2Member);
}
