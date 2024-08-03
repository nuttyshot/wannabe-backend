package wannabe.backend.idol.mapper;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import wannabe.backend.idol.domain.IdolGroup;
import wannabe.backend.idol.domain.IdolGroupId;
import wannabe.backend.idol.gateway.AddIdolGroupDsGateway;
import wannabe.backend.idol.repository.IdolGroupRepository;

@Service
@RequiredArgsConstructor
public class AddIdolGroupDataMapper implements AddIdolGroupDsGateway {

  private final IdolGroupRepository repository;

  @Override
  public IdolGroupId save(@NonNull IdolGroup group) {
    val entity = repository.save(IdolGroupMapper.toEntity(group));
    return new IdolGroupId(entity.getId());
  }
}
