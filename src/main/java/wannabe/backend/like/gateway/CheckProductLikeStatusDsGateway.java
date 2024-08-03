package wannabe.backend.like.gateway;

import lombok.NonNull;
import wannabe.backend.like.domain.ProductLikeStatus;
import wannabe.backend.member.domain.MemberId;
import wannabe.backend.product.domain.ProductId;

public interface CheckProductLikeStatusDsGateway {

  ProductLikeStatus getUserLikeStatusForProduct(@NonNull ProductId productId,
      @NonNull MemberId memberId);
}
