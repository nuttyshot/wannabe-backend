package wannabe.backend.infrastructure.like;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wannabe.backend.like.usecase.checkproductlikestatus.CheckProductLikeStatusDsGateway;
import wannabe.backend.like.usecase.checkproductlikestatus.ProductLikesStatus;
import wannabe.backend.product.entity.ProductId;

@Service
@RequiredArgsConstructor
public class CheckProductLikeStatusDataMapper implements CheckProductLikeStatusDsGateway {

  @Override
  public ProductLikesStatus getUserLikeStatusForProduct(@NonNull ProductId productId) {
    return null;
  }
}
