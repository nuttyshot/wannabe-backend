package wannabe.backend.product.presenter;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import wannabe.backend.idol.domain.FakeIdolMemberFactory;
import wannabe.backend.product.domain.FakeProductFactory;
import wannabe.backend.schedule.domain.FakeScheduleFactory;

@ExtendWith(MockitoExtension.class)
class ProductResponseFormatterTest {

  @InjectMocks
  private ProductResponseFormatter formatter;

  @Test
  void ProductResponse_생성() {
    // given
    // when
    val response = formatter.create(FakeProductFactory.create(), FakeScheduleFactory.create(),
        FakeIdolMemberFactory.create());
    // then
    assertThat(response.productName()).isEqualTo("MOCK_PRODUCT_NAME");
    assertThat(response.productImageUrls()).hasSize(2);
    assertThat(response.idolMemberName()).isEqualTo("MEMBER_NAME");
    assertThat(response.scheduleDate()).isEqualTo(LocalDateTime.MIN.toLocalDate());
    assertThat(response.scheduleName()).isEqualTo("SCHEDULE_NAME");
  }
}