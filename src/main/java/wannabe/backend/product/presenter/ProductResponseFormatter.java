package wannabe.backend.product.presenter;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import wannabe.backend.idol.domain.IdolMember;
import wannabe.backend.product.domain.ImageUrl;
import wannabe.backend.product.domain.Product;
import wannabe.backend.product.interactor.ProductsResponse.ProductResponse;
import wannabe.backend.schedule.domain.Schedule;

@Service
public class ProductResponseFormatter implements ProductResponsePresenter {

  @Override
  public ProductResponse create(@NonNull Product product,
      @NonNull Schedule schedule, @NonNull IdolMember idolMember) {
    return ProductResponse.builder()
        .scheduleDate(schedule.dateTime().value().toLocalDate())
        .scheduleName(schedule.name().value())
        .idolMemberName(idolMember.name().value())
        .productName(product.name())
        .productImageUrls(product.images().images().values().stream().map(ImageUrl::url).toList())
        .build();
  }
}
