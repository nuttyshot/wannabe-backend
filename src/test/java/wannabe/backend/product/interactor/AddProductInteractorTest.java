package wannabe.backend.product.interactor;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import wannabe.backend.idol.domain.FakeIdolMemberFactory;
import wannabe.backend.idol.usecase.FindIdolMemberByNameUseCase;
import wannabe.backend.product.domain.Color;
import wannabe.backend.product.domain.Product;
import wannabe.backend.product.domain.ProductType;
import wannabe.backend.product.dto.AddProductRequest;
import wannabe.backend.product.gateway.AddProductDsGateway;
import wannabe.backend.product.dto.AddProductRequest.Schedule;
import wannabe.backend.schedule.domain.ScheduleId;
import wannabe.backend.schedule.dto.AddScheduleRequest;
import wannabe.backend.schedule.usecase.AddScheduleUseCase;

@ExtendWith(MockitoExtension.class)
class AddProductInteractorTest {

  @InjectMocks
  private AddProductInteractor interactor;

  @Mock
  private FindIdolMemberByNameUseCase findIdolMemberByNameUseCase;

  @Mock
  private AddScheduleUseCase addScheduleUseCase;

  @Mock
  private AddProductDsGateway addProductDsGateway;

  @Test
  void 정상동작() {
    // given
    when(findIdolMemberByNameUseCase.execute(anyString())).thenReturn(FakeIdolMemberFactory.create());
    when(addScheduleUseCase.addSchedule(any())).thenReturn(new ScheduleId(1L));
    // when
    interactor.addProduct(request());
    // then
    verify(findIdolMemberByNameUseCase, only()).execute(anyString());
    verify(addScheduleUseCase, only()).addSchedule(any(AddScheduleRequest.class));
    verify(addProductDsGateway, only()).addProduct(any(Product.class));
  }

  private AddProductRequest request() {
    return AddProductRequest.builder()
        .schedule(Schedule.builder()
            .dateTime(LocalDateTime.MIN)
            .name("MOCK_SCHEDULE_NAME")
            .build())
        .idolMember(AddProductRequest.IdolMember.builder().name("MOCK_IDOL_MEMBER_NAME").build())
        .product(AddProductRequest.Product.builder()
            .name("MOCK_PRODUCT_NAME")
            .price(10000)
            .productType(ProductType.TOP)
            .color(Color.BLACK)
            .imageUrls(List.of())
            .build())
        .build();
  }
}