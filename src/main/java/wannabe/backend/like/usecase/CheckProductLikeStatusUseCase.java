package wannabe.backend.like.usecase;

import lombok.NonNull;
import wannabe.backend.like.domain.ProductLikeStatus;
import wannabe.backend.member.domain.MemberId;
import wannabe.backend.product.domain.ProductId;

public interface CheckProductLikeStatusUseCase {

  ProductLikeStatus execute(@NonNull ProductId productId, MemberId memberId);
}
