package wannabe.backend.init.interactor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wannabe.backend.idol.domain.IdolGroupFactory;
import wannabe.backend.idol.domain.IdolMemberFactory;
import wannabe.backend.idol.usecase.AddIdolGroupUseCase;
import wannabe.backend.idol.usecase.AddIdolMemberUseCase;
import wannabe.backend.init.usecase.InitUseCase;
import wannabe.backend.product.domain.Color;
import wannabe.backend.product.domain.ProductType;
import wannabe.backend.product.domain.StyleType;
import wannabe.backend.product.dto.AddProductRequest;
import wannabe.backend.product.dto.AddProductRequest.IdolMember;
import wannabe.backend.product.dto.AddProductRequest.Product;
import wannabe.backend.product.dto.AddProductRequest.Schedule;
import wannabe.backend.product.usecase.AddProductUseCase;
import wannabe.backend.schedule.dto.AddScheduleRequest;
import wannabe.backend.schedule.usecase.AddScheduleUseCase;

@Service
@Transactional
@RequiredArgsConstructor
public class InitInteractor implements InitUseCase {

  private final AddIdolGroupUseCase addIdolGroupUseCase;
  private final AddIdolMemberUseCase addIdolMemberUseCase;
  private final AddScheduleUseCase addScheduleUseCase;
  private final AddProductUseCase addProductUseCase;

  public void execute() {
    val groupId = addIdolGroupUseCase.execute(IdolGroupFactory.create("NewJeans"));

    List.of("민지", "혜인", "해린", "다니엘", "하니")
        .forEach(name -> addIdolMemberUseCase.execute(IdolMemberFactory.create(name, groupId)));

    addScheduleUseCase.execute(DummyFactory.scheduleRequest());

    IntStream.range(0, 20)
        .forEach(i -> addProductUseCase.execute(DummyFactory.productRequest()));
  }

  private static class DummyFactory {

    private static AddScheduleRequest scheduleRequest() {
      return AddScheduleRequest.builder()
          .name("NewJeans 데뷔 쇼케이스")
          .dateTime(LocalDate.of(2023, 1, 1).atStartOfDay())
          .build();
    }

    private static AddProductRequest productRequest() {
      return AddProductRequest.builder()
          .schedule(Schedule.builder()
              .dateTime(LocalDate.of(2023, 1, 1).atStartOfDay())
              .name("NewJeans 데뷔 쇼케이스")
              .build())
          .idolMember(IdolMember.builder().name("민지").build())
          .product(Product.builder()
              .name("루이비통 맨즈 스포티")
              .brand("루이비통")
              .productType(ProductType.TOP)
              .seller("루이비통")
              .salesLink("https://www.louisvuitton.com/")
              .styleType(StyleType.CASUAL)
              .price(1000000)
              .color(Color.BLACK)
              .imageUrls(
                  List.of("https://www.product-image1.com", "https://www.product-image2.com"))
              .build())
          .build();
    }
  }
}
