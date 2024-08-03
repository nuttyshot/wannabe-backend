package wannabe.backend.like.mapper;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wannabe.backend.like.gateway.CheckProductLikeStatusDsGateway;
import wannabe.backend.like.domain.ProductLikesStatus;
import wannabe.backend.product.domain.ProductId;

@Service
@RequiredArgsConstructor
public class CheckProductLikeStatusDataMapper implements CheckProductLikeStatusDsGateway {

  @Override
  public ProductLikesStatus getUserLikeStatusForProduct(@NonNull ProductId productId) {
    return null;
  }
}
