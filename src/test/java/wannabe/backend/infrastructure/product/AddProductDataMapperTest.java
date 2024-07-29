package wannabe.backend.infrastructure.product;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import wannabe.backend.idol.entity.IdolMemberId;
import wannabe.backend.infrastructure.idol.idolgroup.JpaIdolGroup;
import wannabe.backend.infrastructure.idol.idolgroup.JpaIdolGroupRepository;
import wannabe.backend.infrastructure.idol.idolmember.JpaIdolMember;
import wannabe.backend.infrastructure.idol.idolmember.JpaIdolMemberRepository;
import wannabe.backend.infrastructure.product.productimage.JpaProductImage;
import wannabe.backend.infrastructure.product.productimage.JpaProductImageRepository;
import wannabe.backend.infrastructure.schedule.JpaSchedule;
import wannabe.backend.infrastructure.schedule.JpaScheduleRepository;
import wannabe.backend.product.entity.Color;
import wannabe.backend.product.entity.ImageSequence;
import wannabe.backend.product.entity.ImageUrl;
import wannabe.backend.product.entity.Product;
import wannabe.backend.product.entity.ProductImages;
import wannabe.backend.product.entity.ProductType;
import wannabe.backend.schedule.entity.ScheduleId;

@DataJpaTest
@ActiveProfiles("local")
class AddProductDataMapperTest {

  private AddProductDataMapper mapper;

  @Autowired
  private JpaScheduleRepository scheduleRepository;

  @Autowired
  private JpaIdolMemberRepository idolMemberRepository;

  @Autowired
  private JpaIdolGroupRepository idolGroupRepository;

  @Autowired
  private JpaProductRepository productRepository;

  @Autowired
  private JpaProductImageRepository productImageRepository;

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

  private JpaIdolGroup idolGroup() {
    return JpaIdolGroup.builder()
        .name("MOCK_IDOL_GROUP_NAME")
        .build();
  }

  private JpaIdolMember idolMember(JpaIdolGroup idolGroup) {
    return JpaIdolMember.builder()
        .group(idolGroup)
        .name("MOCK_IDOL_MEMBER_NAME")
        .build();
  }

  private JpaSchedule schedule() {
    return JpaSchedule.builder()
        .name("MOCK_SCHEDULE_NAME")
        .dateTime(LocalDateTime.MIN)
        .build();
  }
}