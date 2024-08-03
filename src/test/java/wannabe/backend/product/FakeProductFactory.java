package wannabe.backend.product;

import java.util.Map;
import wannabe.backend.idol.entity.IdolMemberId;
import wannabe.backend.product.entity.Color;
import wannabe.backend.product.entity.ImageSequence;
import wannabe.backend.product.entity.ImageUrl;
import wannabe.backend.product.entity.Product;
import wannabe.backend.product.entity.ProductId;
import wannabe.backend.product.entity.ProductImages;
import wannabe.backend.product.entity.ProductType;
import wannabe.backend.schedule.entity.ScheduleId;

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
