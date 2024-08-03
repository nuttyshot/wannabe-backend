package wannabe.backend.product.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.Map;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import wannabe.backend.idol.domain.IdolMemberId;
import wannabe.backend.idol.repository.IdolGroupEntity;
import wannabe.backend.idol.repository.IdolGroupRepository;
import wannabe.backend.idol.repository.IdolMemberEntity;
import wannabe.backend.idol.repository.IdolMemberRepository;
import wannabe.backend.product.domain.Color;
import wannabe.backend.product.domain.ImageSequence;
import wannabe.backend.product.domain.ImageUrl;
import wannabe.backend.product.domain.Product;
import wannabe.backend.product.domain.ProductImages;
import wannabe.backend.product.domain.ProductType;
import wannabe.backend.product.repository.ProductImageRepository;
import wannabe.backend.product.repository.ProductRepository;
import wannabe.backend.schedule.domain.ScheduleId;
import wannabe.backend.schedule.repository.ScheduleEntity;
import wannabe.backend.schedule.repository.ScheduleRepository;

@DataJpaTest
@ActiveProfiles("local")
class AddProductDataMapperTest {

  private AddProductDataMapper mapper;

  @Autowired
  private ScheduleRepository scheduleRepository;

  @Autowired
  private IdolMemberRepository idolMemberRepository;

  @Autowired
  private IdolGroupRepository idolGroupRepository;

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private ProductImageRepository productImageRepository;

  @BeforeEach
  void setUp() {
    mapper = new AddProductDataMapper(productRepository, productImageRepository);
  }

  @Test
  void 상품_추가() {
    // given
    val schedule = scheduleRepository.save(schedule());
    val idolGroup = idolGroupRepository.save(idolGroup());
    val idolMember = idolMemberRepository.save(idolMember(idolGroup));
    // when
    mapper.addProduct(Product.builder()
        .name("MOCK_PRODUCT_NAME")
        .scheduleId(new ScheduleId(schedule.getId()))
        .price(10000)
        .productType(ProductType.TOP)
        .color(Color.BLACK)
        .idolMemberId(new IdolMemberId(idolMember.getId()))
        .images(new ProductImages(Map.of(
            new ImageSequence(0), new ImageUrl("MOCK_IMAGE_URL"),
            new ImageSequence(1), new ImageUrl("MOCK_IMAGE_URL"))))
        .build());

    val product = productRepository.findAll().get(0);
    val images = productImageRepository.findByProductId(product.getId());
    // then
    assertThat(product.getName()).isEqualTo("MOCK_PRODUCT_NAME");
    assertThat(product.getIdolMember().getId()).isEqualTo(idolMember.getId());
    assertThat(images.size()).isEqualTo(2);
  }

  private IdolGroupEntity idolGroup() {
    return IdolGroupEntity.builder()
        .name("MOCK_IDOL_GROUP_NAME")
        .build();
  }

  private IdolMemberEntity idolMember(IdolGroupEntity idolGroup) {
    return IdolMemberEntity.builder()
        .group(idolGroup)
        .name("MOCK_IDOL_MEMBER_NAME")
        .build();
  }

  private ScheduleEntity schedule() {
    return ScheduleEntity.builder()
        .name("MOCK_SCHEDULE_NAME")
        .dateTime(LocalDateTime.MIN)
        .build();
  }
}