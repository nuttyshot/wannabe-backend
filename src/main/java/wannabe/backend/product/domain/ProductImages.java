package wannabe.backend.product.domain;

import static java.util.stream.Collectors.toMap;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import lombok.NonNull;

public record ProductImages(@NonNull Map<ImageSequence, ImageUrl> images) {

  public ProductImages(@NonNull List<String> images) {
    this(IntStream.range(0, images.size())
        .boxed()
        .collect(toMap(i -> new ImageSequence(i), i -> new ImageUrl(images.get(i)))));
  }
}
