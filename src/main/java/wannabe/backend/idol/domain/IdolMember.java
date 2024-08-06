package wannabe.backend.idol.domain;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record IdolMember(IdolMemberId id,
                         @NonNull IdolMemberName name,
                         @NonNull IdolGroupId groupId) {

}
