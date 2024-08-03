package wannabe.backend.product.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.NonNull;
import wannabe.backend.product.domain.Color;
import wannabe.backend.product.domain.ProductType;
import wannabe.backend.product.domain.StyleType;
import wannabe.backend.schedule.dto.AddScheduleRequest;

@Builder
public record AddProductRequest(@NonNull Schedule schedule,
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
                        String seller,
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
