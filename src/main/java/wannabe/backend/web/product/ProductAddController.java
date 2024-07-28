package wannabe.backend.web.product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "상품")
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductAddController {

  @Operation(summary = "상품 추가")
  @PostMapping
  public void add(@Valid @RequestBody Body body) {
  }

  record Body(Schedule scheduleDate,
              Product product) {

    record Schedule(
        @NotNull(message = "스케쥴 날짜는 필수 입력 값입니다.")
        LocalDate date,
        @NotNull(message = "스케쥴 이름은 필수 입력 값입니다.")
        String name,
        @NotNull(message = "아이돌 멤버 이름은 필수 입력 값입니다. [민지, 하니, 혜인, 혜린, 다니엘]")
        String idolMemberName) {

    }

    record Product(
        @NotNull(message = "상품 이름은 필수 입력 값입니다.")
        String name,
        @NotNull(message = "브랜드는 필수 입력 값입니다.")
        String brand,
        @NotNull(message = "상품 타입은 필수 입력 값입니다. [TOP, BOTTOM, SHOES, OUTER, HAT, ACC, BAG]")
        String type,
        @NotNull(message = "상품 링크는 필수 입력 값입니다.")
        String saleUrl,
        @NotNull(message = "상품 스타일은 필수 입력 값입니다.")
        String style,
        @NotNull(message = "상품 가격은 필수 입력 값입니다.")
        Integer price,
        @NotNull(message = "상품 색상은 필수 입력 값입니다.")
        String color) {

    }
  }
}
