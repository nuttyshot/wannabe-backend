package wannabe.backend.like.interactor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import wannabe.backend.like.domain.ProductLikeStatus;
import wannabe.backend.like.gateway.CheckProductLikeStatusDsGateway;
import wannabe.backend.member.domain.MemberId;
import wannabe.backend.product.domain.ProductId;

@ExtendWith(MockitoExtension.class)
class CheckProductLikeStatusInteractorTest {

  @InjectMocks
  private CheckProductLikeStatusInteractor interactor;

  @Mock
  private CheckProductLikeStatusDsGateway gateway;

  @Test
  void memberId가_있을시_상품_좋아요_여부_조회() {
    // given
    // when
    interactor.execute(new ProductId(1L), new MemberId(1L));
    // then
    verify(gateway, only()).getUserLikeStatusForProduct(any(), any());
  }

  @Test
  void memberId가_없으면_좋아요_안한다_반환() {
    // given
    // when
    val status = interactor.execute(new ProductId(1L), null);
    // then
    assertThat(status.liked()).isFalse();

    verify(gateway, never()).getUserLikeStatusForProduct(any(), any());
  }
}