package wannabe.backend.product.repository;

import wannabe.backend.idol.repository.IdolMemberEntity;
import wannabe.backend.product.domain.Color;
import wannabe.backend.product.domain.ProductType;
import wannabe.backend.product.domain.StyleType;
import wannabe.backend.schedule.repository.ScheduleEntity;

public class FakeProductEntityFactory {

  public static ProductEntity create(ScheduleEntity schedule, IdolMemberEntity idolMember) {
    return ProductEntity.builder()
        .name("MOCK_PRODUCT_NAME")
        .schedule(schedule)
        .price(10000)
        .productType(ProductType.TOP)
        .styleType(StyleType.CUTE)
        .color(Color.BLUE)
        .idolMember(idolMember)
        .build();
  }
}
