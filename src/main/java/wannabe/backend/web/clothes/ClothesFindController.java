package wannabe.backend.web.clothes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Builder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "상품")
@RestController
@RequestMapping("/clothes/{clothesId}")
public class ClothesFindController {

  @Operation(summary = "상품 상세 조회")
  @GetMapping
  public ClothesResponse find(@PathVariable(value = "clothesId") Long clothesId) {
    return ClothesResponse.builder()
        .clothesId(clothesId)
        .clothesName("MLB 모자 47브랜드 프리미엄 LA 빅로고")
        .imageUrl("https://www.product-image1.com")
        .price(10000)
        .color("파랑")
        .idolMemberName("민지")
        .build();
  }

  @Builder
  private record ClothesResponse(Long clothesId,
                                 String clothesName,
                                 String imageUrl,
                                 int price,
                                 String color,
                                 String idolMemberName) {

  }
}
