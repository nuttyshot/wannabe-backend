package wannabe.backend.like.usecase.checkproductlikestatus;

import lombok.NonNull;
import wannabe.backend.product.entity.ProductId;

public interface CheckProductLikeStatusUseCase {

  ProductLikesStatus execute(@NonNull ProductId productId);
}
