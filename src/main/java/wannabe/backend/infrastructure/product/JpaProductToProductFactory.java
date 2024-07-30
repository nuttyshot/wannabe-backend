package wannabe.backend.infrastructure.product;

import java.util.List;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import wannabe.backend.idol.entity.IdolMemberId;
import wannabe.backend.product.entity.Product;
import wannabe.backend.product.entity.ProductImages;
import wannabe.backend.schedule.entity.ScheduleId;

@Service
public class JpaProductToProductFactory {

  private JpaProductToProductFactory() {
  }

  public static Product create(@NonNull JpaProduct product, @NonNull List<String> imageUrls) {
    return Product.builder()
        .name(product.getName())
        .brand(product.getBrand())
        .productType(product.getProductType())
        .seller(product.getSeller())
        .salesLink(product.getSalesLink())
        .styleType(product.getStyleType())
        .price(product.getPrice())
        .color(product.getColor())
        .images(new ProductImages(imageUrls))
        .scheduleId(new ScheduleId(product.getSchedule().getId()))
        .idolMemberId(new IdolMemberId(product.getIdolMember().getId()))
        .build();
  }
}
