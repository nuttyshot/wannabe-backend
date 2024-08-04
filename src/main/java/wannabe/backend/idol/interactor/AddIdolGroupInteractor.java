package wannabe.backend.idol.interactor;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wannabe.backend.idol.domain.IdolGroup;
import wannabe.backend.idol.domain.IdolGroupId;
import wannabe.backend.idol.gateway.AddIdolGroupDsGateway;
import wannabe.backend.idol.usecase.AddIdolGroupUseCase;

@Service
@Transactional
@RequiredArgsConstructor
public class AddIdolGroupInteractor implements AddIdolGroupUseCase {

  private final AddIdolGroupDsGateway gateway;

  @Override
  public IdolGroupId execute(@NonNull IdolGroup group) {
    return gateway.save(group);
  }
}
