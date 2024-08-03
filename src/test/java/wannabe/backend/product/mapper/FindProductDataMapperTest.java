package wannabe.backend.product.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import wannabe.backend.idol.repository.FakeJpaIdolGroupFactory;
import wannabe.backend.idol.repository.JpaIdolGroupRepository;
import wannabe.backend.idol.repository.FakeJpaIdolMemberFactory;
import wannabe.backend.idol.repository.JpaIdolMemberRepository;
import wannabe.backend.product.repository.FakeJpaProductFactory;
import wannabe.backend.product.repository.FakeJpaProductImageFactory;
import wannabe.backend.product.repository.JpaProductImageRepository;
import wannabe.backend.schedule.repository.FakeJpaScheduleFactory;
import wannabe.backend.schedule.repository.JpaScheduleRepository;
import wannabe.backend.product.repository.JpaProductRepository;

@DataJpaTest
@ActiveProfiles("local")
class FindProductDataMapperTest {

  private FindProductDataMapper mapper;

  @Autowired
  private JpaIdolGroupRepository idolGroupRepository;

  @Autowired
  private JpaIdolMemberRepository idolMemberRepository;

  @Autowired
  private JpaScheduleRepository scheduleRepository;

  @Autowired
  private JpaProductRepository productRepository;

  @Autowired
  private JpaProductImageRepository productImageRepository;

  @BeforeEach
  void setUp() {
    mapper = new FindProductDataMapper(productRepository, productImageRepository);
  }

  @Test
  void 상품_조회() {
    // given
    val idolGroup = idolGroupRepository.save(FakeJpaIdolGroupFactory.create());
    val idolMember = idolMemberRepository.save(FakeJpaIdolMemberFactory.create(idolGroup));
    val schedule = scheduleRepository.save(FakeJpaScheduleFactory.create());
    val product = productRepository.save(FakeJpaProductFactory.create(schedule, idolMember));
    productImageRepository.saveAll(List.of(FakeJpaProductImageFactory.create(product),
        FakeJpaProductImageFactory.create(product)));
    // when
    val findProduct = mapper.findById(product.getId()).get();
    // then
    assertThat(findProduct).isNotNull();
    assertThat(findProduct.scheduleId().value()).isEqualTo(schedule.getId());
    assertThat(findProduct.images().images().values()).hasSize(2);
  }
}