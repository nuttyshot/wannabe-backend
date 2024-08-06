package wannabe.backend.product.interactor;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wannabe.backend.idol.usecase.FindIdolMemberByIdUseCase;
import wannabe.backend.product.gateway.FindAllProductDsGateway;
import wannabe.backend.product.presenter.ProductResponsePresenter;
import wannabe.backend.product.usecase.FindAllProductUseCase;
import wannabe.backend.schedule.domain.Schedule;
import wannabe.backend.schedule.interactor.FindScheduleInteractor;
import wannabe.backend.schedule.usecase.FindScheduleUseCase;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FindAllProductInteractor implements FindAllProductUseCase {

  private final FindAllProductDsGateway findAllProductDsGateway;
  private final FindScheduleUseCase findScheduleUseCase;
  private final FindIdolMemberByIdUseCase findIdolMemberByIdUseCase;
  private final ProductResponsePresenter productResponsePresenter;

  @Override
  public ProductsResponse execute() {
    val products = findAllProductDsGateway.findAll()
        .products()
        .stream()
        .map(i -> {
          val schedule = findScheduleUseCase.execute(i.scheduleId());
          val idolMember = findIdolMemberByIdUseCase.execute(i.idolMemberId());
          return productResponsePresenter.create(i, schedule, idolMember);
        })
        .toList();
    return new ProductsResponse(products);
  }
}
