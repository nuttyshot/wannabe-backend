package wannabe.backend.idol.usecase;

import lombok.NonNull;
import wannabe.backend.idol.domain.IdolGroup;

public interface AddIdolGroupUseCase {

  void execute(@NonNull IdolGroup group);
}
