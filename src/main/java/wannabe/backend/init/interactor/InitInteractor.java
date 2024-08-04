package wannabe.backend.init.interactor;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wannabe.backend.idol.domain.IdolGroupFactory;
import wannabe.backend.idol.domain.IdolMemberFactory;
import wannabe.backend.idol.usecase.AddIdolGroupUseCase;
import wannabe.backend.idol.usecase.AddIdolMemberUseCase;
import wannabe.backend.init.usecase.InitUseCase;

@Service
@Transactional
@RequiredArgsConstructor
public class InitInteractor implements InitUseCase {

  private final AddIdolGroupUseCase addIdolGroupUseCase;
  private final AddIdolMemberUseCase addIdolMemberUseCase;

  public void execute() {
    val groupId = addIdolGroupUseCase.execute(IdolGroupFactory.create("NewJeans"));

    List.of("민지", "혜인", "해린", "다니엘", "하니")
        .forEach(name -> addIdolMemberUseCase.execute(IdolMemberFactory.create(name, groupId)));
  }
}
