package wannabe.backend.core.finduser;

import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class FindMemberInteractor implements FindMemberPort {

  @Override
  public Member findByEmail(@NonNull String email) {
    return null;
  }
}
