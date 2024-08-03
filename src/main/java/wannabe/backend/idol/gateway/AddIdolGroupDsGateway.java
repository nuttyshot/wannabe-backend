package wannabe.backend.idol.gateway;

import lombok.NonNull;
import wannabe.backend.idol.domain.IdolGroup;
import wannabe.backend.idol.domain.IdolGroupId;

public interface AddIdolGroupDsGateway {

  IdolGroupId save(@NonNull IdolGroup group);
}
