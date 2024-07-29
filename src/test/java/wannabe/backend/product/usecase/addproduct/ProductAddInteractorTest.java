package wannabe.backend.product.usecase.addproduct;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import wannabe.backend.idol.entity.IdolMember;
import wannabe.backend.idol.entity.IdolMemberId;
import wannabe.backend.idol.usecase.findidolmember.FindIdolMemberUseCase;
import wannabe.backend.product.entity.Product;
import wannabe.backend.product.entity.ProductType;
import wannabe.backend.product.usecase.addproduct.ProductAddRequest.Schedule;
import wannabe.backend.schedule.entity.ScheduleId;
import wannabe.backend.schedule.usecase.addschedule.AddScheduleRequest;
import wannabe.backend.schedule.usecase.addschedule.AddScheduleUseCase;

@ExtendWith(MockitoExtension.class)
class ProductAddInteractorTest {

  @InjectMocks
  private ProductAddInteractor interactor;

  @Mock
  private FindIdolMemberUseCase findIdolMemberUseCase;

  @Mock
  private AddScheduleUseCase addScheduleUseCase;

  @Mock
  private AddProductDsGateway addProductDsGateway;

  @Test
  void 정상동작() {
    // given
    when(findIdolMemberUseCase.find(anyString())).thenReturn(idolMember());
    when(addScheduleUseCase.addSchedule(any())).thenReturn(new ScheduleId(1L));
    // when
    interactor.addProduct(request());
    // then
    verify(findIdolMemberUseCase, only()).find(anyString());
    verify(addScheduleUseCase, only()).addSchedule(any(AddScheduleRequest.class));
    verify(addProductDsGateway, only()).addProduct(any(Product.class));
  }

  private ProductAddRequest request() {
    return ProductAddRequest.builder()
        .schedule(Schedule.builder()
            .date(LocalDate.MIN)
            .name("MOCK_SCHEDULE_NAME")
            .build())
        .idolMember(ProductAddRequest.IdolMember.builder().name("MOCK_IDOL_MEMBER_NAME").build())
        .product(ProductAddRequest.Product.builder()
            .name("MOCK_PRODUCT_NAME")
            .type(ProductType.TOP)
            .color("MOCK_COLOR")
            .imageUrls(List.of())
            .build())
        .build();
  }

  private static IdolMember idolMember() {
    return IdolMember.builder().id(new IdolMemberId(1L)).build();
  }
}