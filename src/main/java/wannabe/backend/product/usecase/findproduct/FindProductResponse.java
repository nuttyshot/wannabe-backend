package wannabe.backend.product.usecase.findproduct;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.NonNull;
import wannabe.backend.product.entity.Color;

@Builder
public record FindProductResponse(@NonNull List<String> imageUrls,
                                  @NonNull LocalDateTime scheduleDate,
                                  @NonNull String idolMemberName,
                                  @NonNull String productName,
                                  @NonNull List<String> hashTags,
                                  boolean isLike,
                                  String brand,
                                  Integer price,
                                  String seller,
                                  @NonNull Color color,
                                  String salesLink) {

}
