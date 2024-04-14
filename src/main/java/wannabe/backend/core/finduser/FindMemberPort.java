package wannabe.backend.core.finduser;

import lombok.NonNull;

public interface FindMemberPort {

  Member findByEmail(@NonNull String email);
}
