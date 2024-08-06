package wannabe.backend.product.presenter;

import lombok.NonNull;
import wannabe.backend.idol.domain.IdolMember;
import wannabe.backend.product.domain.Product;
import wannabe.backend.product.interactor.ProductsResponse.ProductResponse;
import wannabe.backend.schedule.domain.Schedule;

public interface ProductResponsePresenter {

  ProductResponse create(@NonNull Product product, @NonNull Schedule schedule,
      @NonNull IdolMember idolMember);
}
