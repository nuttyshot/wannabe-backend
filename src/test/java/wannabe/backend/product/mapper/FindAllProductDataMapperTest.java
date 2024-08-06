package wannabe.backend.product.mapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import jakarta.persistence.EntityManager;
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
import wannabe.backend.product.domain.Products;
import wannabe.backend.product.repository.FakeProductEntityFactory;
import wannabe.backend.product.repository.FakeProductImageEntityFactory;
import wannabe.backend.product.repository.ProductImageRepository;
import wannabe.backend.product.repository.ProductRepository;
import wannabe.backend.schedule.repository.FakeScheduleEntityFactory;
import wannabe.backend.schedule.repository.ScheduleRepository;

@DataJpaTest
@ActiveProfiles("local")
class FindAllProductDataMapperTest {

  private FindAllProductDataMapper mapper;

  @Autowired
  private EntityManager entityManager;

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
    mapper = new FindAllProductDataMapper(entityManager);
  }

  @Test
  void 조회한_상품들을_Products로_변환해서_반환() {
    // given
    val idolGroup = idolGroupRepository.save(FakeIdolGroupEntityFactory.create());
    val idolMember = idolMemberRepository.save(FakeIdolMemberEntityFactory.create(idolGroup));
    val schedule = scheduleRepository.save(FakeScheduleEntityFactory.create());
    val product = productRepository.save(FakeProductEntityFactory.create(schedule, idolMember));
    productImageRepository.saveAll(List.of(FakeProductImageEntityFactory.create(product),
        FakeProductImageEntityFactory.create(product)));

    entityManager.flush();
    entityManager.clear();
    // when
    val products = mapper.findAll();
    // then
    assertThat(products.products()).hasSize(1);
    assertThat(products.products().get(0).images().images()).hasSize(2);
  }
}