package wannabe.backend.like.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.val;
import org.junit.jupiter.api.Test;

class ProductLikeStatusTest {

  @Test
  void 좋아요_안했다는_의미() {
    // given
    // when
    val status = ProductLikeStatus.notLike();
    // then
    assertThat(status.liked()).isFalse();
  }
}