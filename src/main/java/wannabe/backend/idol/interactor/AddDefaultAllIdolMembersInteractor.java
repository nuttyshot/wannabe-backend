package wannabe.backend.idol.interactor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wannabe.backend.idol.domain.IdolGroupFactory;
import wannabe.backend.idol.usecase.AddDefaultAllIdolMembersUseCase;
import wannabe.backend.idol.usecase.AddIdolGroupUseCase;

@Service
@Transactional
@RequiredArgsConstructor
public class AddDefaultAllIdolMembersInteractor implements AddDefaultAllIdolMembersUseCase {

  private final AddIdolGroupUseCase addIdolGroupUseCase;

  @Override
  public void execute() {
    addIdolGroupUseCase.execute(IdolGroupFactory.create("NewJeans"));
  }
}
