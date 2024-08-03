package wannabe.backend.like.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductLikesRepository extends JpaRepository<ProductLikeEntity, Long> {

  boolean existsByProduct_IdAndMember_Id(@NonNull Long productId, @NonNull Long memberId);
}
