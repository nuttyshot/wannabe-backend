package wannabe.backend.product.usecase.addproduct;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.NonNull;
import wannabe.backend.product.entity.Color;
import wannabe.backend.product.entity.ProductType;
import wannabe.backend.product.entity.StyleType;
import wannabe.backend.schedule.usecase.addschedule.AddScheduleRequest;

@Builder
public record ProductAddRequest(@NonNull Schedule schedule,
                                @NonNull IdolMember idolMember,
                                @NonNull Product product) {

  @Builder
  public record Schedule(@NonNull LocalDateTime dateTime,
                         @NonNull String name) {

  }

  @Builder
  public record IdolMember(@NonNull String name) {

  }

  @Builder
  public record Product(@NonNull String name,
                        String brand,
                        @NonNull ProductType productType,
                        String salesLink,
                        StyleType styleType,
                        Integer price,
                        @NonNull Color color,
                        @NonNull List<String> imageUrls) {

  }

  public AddScheduleRequest toAddScheduleRequest() {
    return AddScheduleRequest.builder()
        .name(this.schedule.name)
        .dateTime(this.schedule.dateTime)
        .build();
  }
}
