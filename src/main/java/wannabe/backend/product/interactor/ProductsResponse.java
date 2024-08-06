package wannabe.backend.product.interactor;

import java.time.LocalDate;
import java.util.List;
import lombok.Builder;
import lombok.NonNull;

@Builder
public record ProductsResponse(@NonNull List<ProductResponse> productResponses) {

  @Builder
  public record ProductResponse(@NonNull LocalDate scheduleDate,
                                @NonNull String scheduleName,
                                @NonNull String idolMemberName,
                                @NonNull String productName,
                                @NonNull List<String> productImageUrls) {

  }
}
