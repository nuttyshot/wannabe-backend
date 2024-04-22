package wannabe.backend.web.main;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.NonNull;

@Builder
record ProductsResponse(@NonNull List<ProductResponse> productResponses) {

  @Builder
  record ProductResponse(@NonNull LocalDateTime eventDate,
                         @NonNull String eventName,
                         @NonNull String celebrityName,
                         @NonNull String productName,
                         @NonNull List<String> hashTags,
                         @NonNull List<String> productImages) {

  }
}
