package wannabe.backend.product.repository;

import java.util.List;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProductImageRepository extends JpaRepository<JpaProductImage, Long> {

  List<JpaProductImage> findByProductId(@NonNull Long productId);
}
