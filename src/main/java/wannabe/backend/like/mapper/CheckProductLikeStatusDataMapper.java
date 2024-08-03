package wannabe.backend.like.mapper;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import wannabe.backend.like.domain.ProductLikeStatus;
import wannabe.backend.like.gateway.CheckProductLikeStatusDsGateway;
import wannabe.backend.like.repository.ProductLikesRepository;
import wannabe.backend.member.domain.MemberId;
import wannabe.backend.product.domain.ProductId;

@Service
@RequiredArgsConstructor
public class CheckProductLikeStatusDataMapper implements CheckProductLikeStatusDsGateway {

  private final ProductLikesRepository repository;

  @Override
  public ProductLikeStatus getUserLikeStatusForProduct(@NonNull ProductId productId,
      @NonNull MemberId memberId) {

    val result = repository.existsByProduct_IdAndMember_Id(productId.value(), memberId.value());
    return new ProductLikeStatus(result);
  }
}
