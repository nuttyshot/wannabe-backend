package wannabe.backend.infrastructure.product;

import wannabe.backend.infrastructure.idol.idolmember.JpaIdolMember;
import wannabe.backend.infrastructure.schedule.JpaSchedule;
import wannabe.backend.product.entity.Color;
import wannabe.backend.product.entity.ProductType;
import wannabe.backend.product.entity.StyleType;

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
