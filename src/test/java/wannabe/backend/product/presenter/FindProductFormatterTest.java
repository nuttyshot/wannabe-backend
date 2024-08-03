package wannabe.backend.product.presenter;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import wannabe.backend.idol.domain.FakeIdolMemberFactory;
import wannabe.backend.like.domain.ProductLikeStatus;
import wannabe.backend.product.domain.FakeProductFactory;
import wannabe.backend.schedule.domain.FakeScheduleFactory;

@ExtendWith(MockitoExtension.class)
class FindProductFormatterTest {

  @InjectMocks
  private FindProductFormatter formatter;

  @Test
  void FindProductResponse_생성() {
    // given
    // when
    val response = formatter.create(FakeProductFactory.create(),
        FakeScheduleFactory.create(),
        FakeIdolMemberFactory.create(), ProductLikeStatus.notLike());
    // then
    assertThat(response.imageUrls().size()).isEqualTo(2);
    assertThat(response.idolMemberName()).isEqualTo("MEMBER_NAME");
  }
}