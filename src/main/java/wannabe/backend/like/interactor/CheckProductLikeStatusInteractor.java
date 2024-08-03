package wannabe.backend.like.interactor;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wannabe.backend.like.usecase.CheckProductLikeStatusUseCase;
import wannabe.backend.like.gateway.CheckProductLikeStatusDsGateway;
import wannabe.backend.like.domain.ProductLikeStatus;
import wannabe.backend.member.domain.MemberId;
import wannabe.backend.product.domain.ProductId;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CheckProductLikeStatusInteractor implements CheckProductLikeStatusUseCase {

  private final CheckProductLikeStatusDsGateway gateway;

  @Override
  public ProductLikeStatus execute(@NonNull ProductId productId, MemberId memberId) {
    if (memberId == null) {
      return ProductLikeStatus.notLike();
    }
    return gateway.getUserLikeStatusForProduct(productId, memberId);
  }
}
