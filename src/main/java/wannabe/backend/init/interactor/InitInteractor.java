package wannabe.backend.init.interactor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wannabe.backend.idol.domain.IdolGroupFactory;
import wannabe.backend.idol.usecase.AddIdolGroupUseCase;
import wannabe.backend.init.usecase.InitUseCase;

@Service
@Transactional
@RequiredArgsConstructor
public class InitInteractor implements InitUseCase {

  private final AddIdolGroupUseCase useCase;

  public void execute() {
    useCase.execute(IdolGroupFactory.create("NewJeans"));
  }
}
