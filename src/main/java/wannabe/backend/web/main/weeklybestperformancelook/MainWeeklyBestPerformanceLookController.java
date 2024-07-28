package wannabe.backend.web.main.weeklybestperformancelook;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wannabe.backend.web.main.ProductsResponse;
import wannabe.backend.web.main.ProductsResponse.ProductResponse;

@Tag(name = "메인")
@RestController
@RequestMapping("/main/weekly-best-performance-look")
public class MainWeeklyBestPerformanceLookController {

  @Operation(summary = "WEEKLY BEST PERFORMANCE LOOK 조회")
  @GetMapping
  public ProductsResponse find(@PageableDefault(page = 0, size = 10) Pageable pageable) {

    return ProductsResponse.builder()
        .productResponses(List.of(
            ProductResponse.builder()
                .eventDate(LocalDate.of(2023, 7, 1))
                .eventName("어텐션 뮤직뱅크")
                .idolMemberName("민지")
                .productName("루이비통 맨즈 스포티")
                .productImageUrls(
                    List.of("https://www.product-image1.com", "https://www.product-image2.com"))
                .build(),
            ProductResponse.builder()
                .eventDate(LocalDate.of(2023, 7, 1))
                .eventName("어텐션 뮤직뱅크")
                .idolMemberName("민지")
                .productName("루이비통 맨즈 스포티")
                .productImageUrls(
                    List.of("https://www.product-image1.com", "https://www.product-image2.com"))
                .build()
        ))
        .build();
  }
}
