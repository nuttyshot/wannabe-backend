package wannabe.backend.product.usecase.addproduct;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wannabe.backend.idol.usecase.findidolmember.FindIdolMemberUseCase;
import wannabe.backend.product.entity.ProductFactory;
import wannabe.backend.schedule.usecase.addschedule.AddScheduleUseCase;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductAddInteractor implements ProductAddUseCase {

  private final FindIdolMemberUseCase findIdolMemberUseCase;
  private final AddScheduleUseCase addScheduleUseCase;
  private final AddProductDsGateway addProductDsGateway;

  @Override
  public void addProduct(@NonNull ProductAddRequest request) {
    // 아이돌 멤버를 찾는다.
    val idolMember = findIdolMemberUseCase.find(request.idolMember().name());
    // 스케쥴을 추가한다.
    val scheduleId = addScheduleUseCase.addSchedule(request.toAddScheduleRequest());
    // 상품을 추가한다.
    addProductDsGateway.addProduct(
        ProductFactory.create(request.product(), scheduleId, idolMember.id()));
  }
}
