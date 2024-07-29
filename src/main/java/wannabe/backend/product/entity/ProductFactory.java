package wannabe.backend.product.entity;

import static java.util.stream.Collectors.toMap;

import java.util.List;
import java.util.stream.IntStream;
import lombok.NonNull;
import lombok.val;
import wannabe.backend.idol.entity.IdolMemberId;
import wannabe.backend.product.usecase.addproduct.ProductAddRequest;
import wannabe.backend.schedule.entity.ScheduleId;

public class ProductFactory {

  public static Product create(
      @NonNull ProductAddRequest.Product product,
      @NonNull ScheduleId scheduleId,
      @NonNull IdolMemberId idolMemberId
  ) {

    return Product.builder()
        .name(product.name())
        .brand(product.brand())
        .productType(product.productType())
        .seller(product.seller())
        .salesLink(product.salesLink())
        .styleType(product.styleType())
        .price(product.price())
        .color(product.color())
        .images(images(product.imageUrls()))
        .scheduleId(scheduleId)
        .idolMemberId(idolMemberId)
        .build();
  }

  private static ProductImages images(@NonNull List<String> imageUrls) {
    val imageUrlMap = IntStream.range(0, imageUrls.size())
        .boxed()
        .collect(toMap(i -> new ImageSequence(i), i -> new ImageUrl(imageUrls.get(i))));
    return new ProductImages(imageUrlMap);
  }
}
