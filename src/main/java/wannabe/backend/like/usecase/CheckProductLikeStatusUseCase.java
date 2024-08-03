package wannabe.backend.like.usecase;

import lombok.NonNull;
import wannabe.backend.like.domain.ProductLikesStatus;
import wannabe.backend.product.domain.ProductId;

public interface CheckProductLikeStatusUseCase {

  ProductLikesStatus execute(@NonNull ProductId productId);
}
