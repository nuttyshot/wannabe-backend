package wannabe.backend.product.presenter;

import java.util.List;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import wannabe.backend.idol.domain.IdolMember;
import wannabe.backend.like.domain.ProductLikeStatus;
import wannabe.backend.product.domain.ImageUrl;
import wannabe.backend.product.domain.Product;
import wannabe.backend.product.dto.FindProductResponse;
import wannabe.backend.schedule.domain.Schedule;

@Service
public class FindProductFormatter implements FindProductPresenter {

  @Override
  public FindProductResponse create(@NonNull Product product, Schedule schedule,
      @NonNull IdolMember idolMember, @NonNull ProductLikeStatus likesStatus) {
    return FindProductResponse.builder()
        .imageUrls(product.images().images().values().stream().map(ImageUrl::url).toList())
        .scheduleDate(schedule.dateTime().value())
        .idolMemberName(idolMember.name().value())
        .productName(product.name())
        .hashTags(fakeHashTags())
        .isLike(likesStatus.liked())
        .brand(product.brand())
        .price(product.price())
        .seller(product.seller())
        .color(product.color())
        .salesLink(product.salesLink())
        .build();
  }

  private List<String> fakeHashTags() {
    return List.of("해시태그1", "해시태그2", "해시태그3");
  }
}
