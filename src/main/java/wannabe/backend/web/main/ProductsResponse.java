package wannabe.backend.web.main;

import java.time.LocalDate;
import java.util.List;
import lombok.Builder;
import lombok.NonNull;

@Builder
public record ProductsResponse(@NonNull List<ProductResponse> productResponses) {

  @Builder
  public record ProductResponse(@NonNull LocalDate eventDate,
                                @NonNull String eventName,
                                @NonNull String idolMemberName,
                                @NonNull String clothesName,
                                @NonNull List<String> clothesImageUrls) {

  }
}
