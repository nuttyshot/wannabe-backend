package wannabe.backend.web.product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.intellij.lang.annotations.Pattern;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wannabe.backend.product.domain.Color;
import wannabe.backend.product.domain.ProductType;
import wannabe.backend.product.domain.StyleType;
import wannabe.backend.product.dto.AddProductRequest;
import wannabe.backend.product.dto.AddProductRequest.IdolMember;
import wannabe.backend.product.dto.AddProductRequest.Product;
import wannabe.backend.product.dto.AddProductRequest.Schedule;
import wannabe.backend.product.usecase.AddProductUseCase;

@Tag(name = "상품")
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductAddController {

  private final AddProductUseCase useCase;

  @Operation(summary = "상품 추가")
  @PostMapping
  public void add(@Valid @RequestBody Body body) {
    useCase.execute(request(body));
  }

  private AddProductRequest request(@NonNull Body body) {
    return AddProductRequest.builder()
        .schedule(Schedule.builder()
            .dateTime(body.scheduleDate().dateTime())
            .name(body.scheduleDate().name())
            .build())
        .idolMember(IdolMember.builder()
            .name(body.scheduleDate().idolMemberName())
            .build())
        .product(Product.builder()
            .name(body.product().name())
            .brand(body.product().brand())
            .productType(body.product().productType())
            .seller(body.product().seller())
            .salesLink(body.product().salesLink())
            .styleType(body.product().styleType())
            .price(body.product().price())
            .color(body.product().color())
            .imageUrls(body.product().imageUrls())
            .build())
        .build();
  }

  record Body(Schedule scheduleDate,
              Product product) {

    record Schedule(
        @NotNull(message = "스케쥴 날짜는 필수 입력 값입니다.")
        LocalDateTime dateTime,
        @NotNull(message = "스케쥴 이름은 필수 입력 값입니다.")
        String name,
        @NotNull(message = "아이돌 멤버 이름은 필수 입력 값입니다. [민지, 하니, 혜인, 혜린, 다니엘]")
        @Pattern(value = "^(민지|하니|혜인|혜린|다니엘)$")
        String idolMemberName) {

    }

    record Product(
        @NotNull(message = "상품 이름은 필수 입력 값입니다.")
        String name,
        String brand,
        @NotNull(message = "상품 타입은 필수 입력 값입니다. [TOP, BOTTOM, SHOES, OUTER, HAT, BAG, ACC]")
        ProductType productType,
        String seller,
        String salesLink,
        StyleType styleType,
        Integer price,
        @NotNull(message = "상품 색상은 필수 입력 값입니다.")
        Color color,
        @NotNull(message = "상품 이미지 URL은 필수 입력 값입니다.")
        List<String> imageUrls) {

    }
  }
}
