package wannabe.backend.like.usecase.checkproductlikestatus;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wannabe.backend.product.entity.ProductId;

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
