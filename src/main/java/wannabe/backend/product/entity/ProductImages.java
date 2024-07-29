package wannabe.backend.product.entity;

import java.util.Map;
import lombok.NonNull;

public record ProductImages(@NonNull Map<ImageSequence, ImageUrl> images) {

}
