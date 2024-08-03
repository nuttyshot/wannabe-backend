package wannabe.backend.product.usecase.findproduct;

import java.util.List;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import wannabe.backend.idol.entity.IdolMember;
import wannabe.backend.like.usecase.checkproductlikestatus.ProductLikesStatus;
import wannabe.backend.product.entity.ImageUrl;
import wannabe.backend.product.entity.Product;
import wannabe.backend.product.usecase.addproduct.ProductAddRequest.Schedule;

@Service
public class FindProductFormatter implements FindProductPresenter {

  @Override
  public FindProductResponse create(@NonNull Product product, @NonNull Schedule schedule,
      @NonNull IdolMember idolMember, @NonNull ProductLikesStatus likesStatus) {
    return FindProductResponse.builder()
        .imageUrls(product.images().images().values().stream().map(ImageUrl::url).toList())
        .scheduleDate(schedule.dateTime())
        .idolMemberName(idolMember.name().name())
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
