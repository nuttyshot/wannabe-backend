package wannabe.backend.product.presenter;

import lombok.NonNull;
import wannabe.backend.idol.domain.IdolMember;
import wannabe.backend.like.domain.ProductLikesStatus;
import wannabe.backend.product.domain.Product;
import wannabe.backend.product.dto.AddProductRequest.Schedule;
import wannabe.backend.product.dto.FindProductResponse;

public interface FindProductPresenter {

  FindProductResponse create(@NonNull Product product, @NonNull Schedule schedule,
      @NonNull IdolMember idolMember, @NonNull ProductLikesStatus likesStatus);
}
