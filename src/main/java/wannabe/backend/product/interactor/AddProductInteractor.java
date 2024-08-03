package wannabe.backend.product.interactor;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wannabe.backend.idol.usecase.FindIdolMemberByNameUseCase;
import wannabe.backend.product.domain.factory.ProductFactory;
import wannabe.backend.product.dto.AddProductRequest;
import wannabe.backend.product.gateway.AddProductDsGateway;
import wannabe.backend.product.usecase.ProductAddUseCase;
import wannabe.backend.schedule.usecase.AddScheduleUseCase;

@Service
@Transactional
@RequiredArgsConstructor
public class AddProductInteractor implements ProductAddUseCase {

  private final FindIdolMemberByNameUseCase findIdolMemberByNameUseCase;
  private final AddScheduleUseCase addScheduleUseCase;
  private final AddProductDsGateway addProductDsGateway;

  @Override
  public void addProduct(@NonNull AddProductRequest request) {
    // 아이돌 멤버를 찾는다.
    val idolMember = findIdolMemberByNameUseCase.execute(request.idolMember().name());
    // 스케쥴을 추가한다.
    val scheduleId = addScheduleUseCase.addSchedule(request.toAddScheduleRequest());
    // 상품을 추가한다.
    addProductDsGateway.addProduct(
        ProductFactory.create(request.product(), scheduleId, idolMember.id()));
  }
}
