package wannabe.backend.product.mapper;

import static wannabe.backend.product.repository.QProductEntity.productEntity;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.val;
import org.springframework.stereotype.Service;
import wannabe.backend.product.domain.Products;
import wannabe.backend.product.gateway.FindAllProductDsGateway;
import wannabe.backend.product.repository.ProductImageEntity;

@Service
public class FindAllProductDataMapper implements FindAllProductDsGateway {

  private final JPAQueryFactory queryFactory;

  public FindAllProductDataMapper(EntityManager entityManager) {
    this.queryFactory = new JPAQueryFactory(entityManager);
  }

  @Override
  public Products findAll() {
    val products = queryFactory.selectFrom(productEntity)
        .join(productEntity.images).fetchJoin()
        .fetch()
        .stream()
        .map(i -> JpaProductToProductFactory.create(i, i.getImages().stream().map(
            ProductImageEntity::getUrl).toList()))
        .toList();
    return new Products(products);
  }
}
