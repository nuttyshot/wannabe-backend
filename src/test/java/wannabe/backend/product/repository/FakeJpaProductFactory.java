package wannabe.backend.product.repository;

import wannabe.backend.idol.repository.JpaIdolMember;
import wannabe.backend.schedule.repository.JpaSchedule;
import wannabe.backend.product.domain.Color;
import wannabe.backend.product.domain.ProductType;
import wannabe.backend.product.domain.StyleType;

public class FakeJpaProductFactory {

  public static JpaProduct create(JpaSchedule schedule, JpaIdolMember idolMember) {
    return JpaProduct.builder()
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
