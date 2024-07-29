package wannabe.backend.idol.entity;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record IdolMember(@NonNull IdolMemberId id) {

}
