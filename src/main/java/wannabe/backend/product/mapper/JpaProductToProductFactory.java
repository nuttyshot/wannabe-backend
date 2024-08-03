package wannabe.backend.product.mapper;

import java.util.List;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import wannabe.backend.idol.domain.IdolMemberId;
import wannabe.backend.product.repository.JpaProduct;
import wannabe.backend.product.domain.Product;
import wannabe.backend.product.domain.ProductImages;
import wannabe.backend.schedule.domain.ScheduleId;

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
