package wannabe.backend.web.main.news;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wannabe.backend.product.interactor.ProductsResponse;
import wannabe.backend.product.usecase.FindAllProductUseCase;

@Tag(name = "메인")
@RestController
@RequestMapping("/main/new")
@RequiredArgsConstructor
public class MainNewController {

  private final FindAllProductUseCase useCase;

  @Operation(summary = "NEW 상품 조회")
  @GetMapping
  public ProductsResponse find(@PageableDefault(page = 0, size = 10) Pageable pageable) {
    return useCase.execute();
  }
}
