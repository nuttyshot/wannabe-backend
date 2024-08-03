package wannabe.backend.like.interactor;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wannabe.backend.like.usecase.CheckProductLikeStatusUseCase;
import wannabe.backend.like.gateway.CheckProductLikeStatusDsGateway;
import wannabe.backend.like.domain.ProductLikesStatus;
import wannabe.backend.product.domain.ProductId;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CheckProductLikeStatusInteractor implements CheckProductLikeStatusUseCase {

  private final CheckProductLikeStatusDsGateway gateway;

  @Override
  public ProductLikesStatus execute(@NonNull ProductId productId) {
    return gateway.getUserLikeStatusForProduct(productId);
  }
}
