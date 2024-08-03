package wannabe.backend.product.domain;

import lombok.Builder;
import lombok.NonNull;
import wannabe.backend.idol.domain.IdolMemberId;
import wannabe.backend.schedule.domain.ScheduleId;

@Builder
public record Product(ProductId id,
                      @NonNull String name,
                      String brand,
                      @NonNull ProductType productType,
                      String seller,
                      String salesLink,
                      StyleType styleType,
                      Integer price,
                      @NonNull Color color,
                      @NonNull ProductImages images,
                      @NonNull ScheduleId scheduleId,
                      @NonNull IdolMemberId idolMemberId) {

}
