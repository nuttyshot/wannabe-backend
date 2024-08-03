package wannabe.backend.product.domain;

import java.util.Map;
import wannabe.backend.idol.domain.IdolMemberId;
import wannabe.backend.schedule.domain.ScheduleId;

public class FakeProductFactory {

  public static Product create() {
    return Product.builder()
        .id(new ProductId(1L))
        .name("MOCK_PRODUCT_NAME")
        .productType(ProductType.TOP)
        .color(Color.BLACK)
        .images(new ProductImages(Map.of(
            new ImageSequence(0), new ImageUrl("MOCK_IMAGE_URL"),
            new ImageSequence(1), new ImageUrl("MOCK_IMAGE_URL"))))
        .scheduleId(new ScheduleId(1L))
        .idolMemberId(new IdolMemberId(2L))
        .build();
  }
}
