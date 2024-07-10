package wannabe.backend.web.main.weeklybestperformancelook;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wannabe.backend.web.main.ProductsResponse;
import wannabe.backend.web.main.ProductsResponse.ProductResponse;

@RestController
@RequestMapping("/main/weekly-best-performance-look")
public class MainWeeklyBestPerformanceLookController {

  @GetMapping
  public ProductsResponse find(@PageableDefault(page = 0, size = 10) Pageable pageable) {

    return ProductsResponse.builder()
        .productResponses(List.of(
            ProductResponse.builder()
                .eventDate(LocalDate.of(2023, 7, 1))
                .eventName("어텐션 뮤직뱅크")
                .idolMemberName("민지")
                .clothesName("루이비통 맨즈 스포티")
                .clothesImageUrls(
                    List.of("https://www.product-image1.com", "https://www.product-image2.com"))
                .build(),
            ProductResponse.builder()
                .eventDate(LocalDate.of(2023, 7, 1))
                .eventName("어텐션 뮤직뱅크")
                .idolMemberName("민지")
                .clothesName("루이비통 맨즈 스포티")
                .clothesImageUrls(
                    List.of("https://www.product-image1.com", "https://www.product-image2.com"))
                .build()
        ))
        .build();
  }
}
