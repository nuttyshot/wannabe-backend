package wannabe.backend.like.gateway;

import lombok.NonNull;
import wannabe.backend.like.domain.ProductLikesStatus;
import wannabe.backend.product.domain.ProductId;

public interface CheckProductLikeStatusDsGateway {

  ProductLikesStatus getUserLikeStatusForProduct(@NonNull ProductId productId);
}
