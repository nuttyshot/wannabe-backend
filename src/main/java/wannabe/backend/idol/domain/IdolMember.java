package wannabe.backend.idol.domain;

import static lombok.AccessLevel.PACKAGE;

import lombok.Builder;
import lombok.NonNull;

@Builder(access = PACKAGE)
public record IdolMember(@NonNull IdolMemberId id,
                         @NonNull IdolMemberName name) {

}
