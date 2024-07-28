package wannabe.backend.core.product.usecase;

import java.time.LocalDate;
import java.util.List;
import lombok.Builder;
import lombok.NonNull;
import wannabe.backend.core.product.entity.ProductType;

@Builder
public record ProductAddRequest(@NonNull Schedule schedule,
                                @NonNull IdolMember idolMember,
                                @NonNull Product product) {

  @Builder
  public record Schedule(@NonNull LocalDate date,
                         @NonNull String name) {

  }

  @Builder
  public record IdolMember(@NonNull String name) {

  }

  @Builder
  public record Product(@NonNull String name,
                        String brand,
                        @NonNull ProductType type,
                        String salesLink,
                        String style,
                        Integer price,
                        @NonNull String color,
                        @NonNull List<String> imageUrls) {

  }

}
