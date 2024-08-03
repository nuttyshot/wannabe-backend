package wannabe.backend.web.product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wannabe.backend.product.dto.FindProductResponse;
import wannabe.backend.product.usecase.FindProductUseCase;

@Tag(name = "상품")
@RestController
@RequestMapping("/products/{productId}")
@RequiredArgsConstructor
public class FindProductController {

  private final FindProductUseCase useCase;

  @Operation(summary = "상품 상세 조회")
  @GetMapping
  public FindProductResponse find(@PathVariable(value = "productId") Long productId) {
    return useCase.execute(productId);
  }
}
