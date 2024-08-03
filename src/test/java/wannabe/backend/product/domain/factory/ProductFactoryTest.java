package wannabe.backend.product.domain.factory;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lombok.val;
import org.junit.jupiter.api.Test;
import wannabe.backend.idol.domain.IdolMemberId;
import wannabe.backend.product.domain.Color;
import wannabe.backend.product.domain.ImageSequence;
import wannabe.backend.product.domain.ImageUrl;
import wannabe.backend.product.domain.ProductType;
import wannabe.backend.product.dto.AddProductRequest;
import wannabe.backend.schedule.domain.ScheduleId;

class ProductFactoryTest {

  @Test
  void 상품_생성() {
    // given
    // when
    val product = ProductFactory.create(AddProductRequest.Product.builder()
            .name("MOCK_PRODUCT_NAME")
            .price(10000)
            .productType(ProductType.TOP)
            .color(Color.BLACK)
            .imageUrls(List.of("MOCK_IMAGE_URL1", "MOCK_IMAGE_URL2"))
            .build(),
        new ScheduleId(1L),
        new IdolMemberId(1L));
    // then
    assertThat(product.name()).isEqualTo("MOCK_PRODUCT_NAME");
    assertThat(product.scheduleId().value()).isEqualTo(1L);
    assertThat(product.images().images().size()).isEqualTo(2);
    assertThat(product.images().images()).isEqualTo(
        Map.of(new ImageSequence(0), new ImageUrl("MOCK_IMAGE_URL1"),
            new ImageSequence(1), new ImageUrl("MOCK_IMAGE_URL2")));
  }
}