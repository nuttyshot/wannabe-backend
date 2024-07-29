package wannabe.backend.product.entity;

import lombok.Builder;
import lombok.NonNull;
import wannabe.backend.idol.entity.IdolMemberId;
import wannabe.backend.schedule.entity.ScheduleId;

@Builder
public record Product(@NonNull String name,
                      @NonNull ScheduleId scheduleId,
                      int price,
                      @NonNull ProductType productType,
                      String salesLink,
                      @NonNull Color color,
                      StyleType styleType,
                      @NonNull IdolMemberId idolMemberId,
                      @NonNull ProductImages images) {

}
