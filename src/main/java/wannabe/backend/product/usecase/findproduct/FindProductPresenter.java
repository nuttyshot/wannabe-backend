package wannabe.backend.product.usecase.findproduct;

import lombok.NonNull;
import wannabe.backend.idol.entity.IdolMember;
import wannabe.backend.like.usecase.checkproductlikestatus.ProductLikesStatus;
import wannabe.backend.product.entity.Product;
import wannabe.backend.product.usecase.addproduct.ProductAddRequest.Schedule;

public interface FindProductPresenter {

  FindProductResponse create(@NonNull Product product, @NonNull Schedule schedule,
      @NonNull IdolMember idolMember, @NonNull ProductLikesStatus likesStatus);
}
