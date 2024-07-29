package wannabe.backend.product.entity;

import lombok.NonNull;
import wannabe.backend.idol.entity.IdolMemberId;
import wannabe.backend.product.usecase.addproduct.ProductAddRequest;
import wannabe.backend.schedule.entity.ScheduleId;

public class ProductFactory {

  public static Product create(
      @NonNull ProductAddRequest.Product product,
      @NonNull ScheduleId scheduleId,
      @NonNull IdolMemberId idolMemberId
  ) {

    return new Product();
  }
}
