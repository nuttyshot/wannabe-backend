package wannabe.backend.product.interactor;

import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wannabe.backend.idol.usecase.FindIdolMemberByIdUseCase;
import wannabe.backend.like.usecase.CheckProductLikeStatusUseCase;
import wannabe.backend.product.dto.FindProductResponse;
import wannabe.backend.product.gateway.FindProductDsGateway;
import wannabe.backend.product.presenter.FindProductPresenter;
import wannabe.backend.product.usecase.FindProductUseCase;
import wannabe.backend.schedule.usecase.FindScheduleUseCase;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FindProductInteractor implements FindProductUseCase {

  private final FindProductDsGateway gateway;
  private final FindProductPresenter presenter;
  private final FindScheduleUseCase findScheduleUseCase;
  private final FindIdolMemberByIdUseCase findIdolMemberByIdUseCase;
  private final CheckProductLikeStatusUseCase checkProductLikeStatusUseCase;

  @Override
  public FindProductResponse execute(long productId) {
    val product = gateway.findById(productId)
        .orElseThrow(() -> new NoSuchElementException("상품을 찾을 수 없습니다 : " + productId));

    val schedule = findScheduleUseCase.execute(product.scheduleId());
    val idolMember = findIdolMemberByIdUseCase.execute(product.idolMemberId());
    val likesCount = checkProductLikeStatusUseCase.execute(product.id(), null);
    return presenter.create(product, schedule, idolMember, likesCount);
  }
}
