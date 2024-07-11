package wannabe.backend.web.clothes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "상품")
@RestController
@RequestMapping("/clothes")
public class ClothesAddController {

  @Operation(summary = "상품 추가")
  @PostMapping
  public void add(@RequestBody Body body) {
  }

  record Body(String imageUrl,
              String brand,
              String idolMemberName) {

  }
}
