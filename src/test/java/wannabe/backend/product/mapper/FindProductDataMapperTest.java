package wannabe.backend.product.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import wannabe.backend.idol.repository.FakeIdolGroupEntityFactory;
import wannabe.backend.idol.repository.FakeIdolMemberEntityFactory;
import wannabe.backend.idol.repository.IdolGroupRepository;
import wannabe.backend.idol.repository.IdolMemberRepository;
import wannabe.backend.product.repository.FakeProductEntityFactory;
import wannabe.backend.product.repository.FakeProductImageEntityFactory;
import wannabe.backend.product.repository.ProductImageRepository;
import wannabe.backend.product.repository.ProductRepository;
import wannabe.backend.schedule.repository.FakeScheduleEntityFactory;
import wannabe.backend.schedule.repository.ScheduleRepository;


@DataJpaTest
@ActiveProfiles("local")
class FindProductDataMapperTest {

  private FindProductDataMapper mapper;

  @Autowired
  private IdolGroupRepository idolGroupRepository;

  @Autowired
  private IdolMemberRepository idolMemberRepository;

  @Autowired
  private ScheduleRepository scheduleRepository;

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private ProductImageRepository productImageRepository;

  @BeforeEach
  void setUp() {
    mapper = new FindProductDataMapper(productRepository, productImageRepository);
  }

  @Test
  void 상품_조회() {
    // given
    val idolGroup = idolGroupRepository.save(FakeIdolGroupEntityFactory.create());
    val idolMember = idolMemberRepository.save(FakeIdolMemberEntityFactory.create(idolGroup));
    val schedule = scheduleRepository.save(FakeScheduleEntityFactory.create());
    val product = productRepository.save(FakeProductEntityFactory.create(schedule, idolMember));
    productImageRepository.saveAll(List.of(FakeProductImageEntityFactory.create(product),
        FakeProductImageEntityFactory.create(product)));
    // when
    val findProduct = mapper.findById(product.getId()).get();
    // then
    assertThat(findProduct).isNotNull();
    assertThat(findProduct.scheduleId().value()).isEqualTo(schedule.getId());
    assertThat(findProduct.images().images().values()).hasSize(2);
  }
}