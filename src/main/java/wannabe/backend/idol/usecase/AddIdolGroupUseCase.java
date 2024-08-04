package wannabe.backend.idol.usecase;

import lombok.NonNull;
import wannabe.backend.idol.domain.IdolGroup;
import wannabe.backend.idol.domain.IdolGroupId;

public interface AddIdolGroupUseCase {

  IdolGroupId execute(@NonNull IdolGroup group);
}
