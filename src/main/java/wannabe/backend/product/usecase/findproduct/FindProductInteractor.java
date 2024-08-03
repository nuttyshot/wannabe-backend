package wannabe.backend.product.usecase.findproduct;

import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wannabe.backend.idol.usecase.findidolmemberbyid.FindIdolMemberByIdUseCase;
import wannabe.backend.like.usecase.checkproductlikestatus.CheckProductLikeStatusUseCase;
import wannabe.backend.schedule.usecase.findschedule.FindScheduleUseCase;

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
  public FindProductResponse findProduct(long productId) {
    val product = gateway.findById(productId)
        .orElseThrow(() -> new NoSuchElementException("상품을 찾을 수 없습니다 : " + productId));

    val schedule = findScheduleUseCase.execute(product.scheduleId());
    val idolMember = findIdolMemberByIdUseCase.execute(product.idolMemberId());
    val likesCount = checkProductLikeStatusUseCase.execute(product.id());
    return presenter.create(product, schedule, idolMember, likesCount);
  }
}
