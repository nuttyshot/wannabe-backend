package wannabe.backend.web.clothes;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clothes")
public class ClothesAddController {

  @PostMapping
  public void add(@RequestBody Body body) {
  }

  record Body(String imageUrl,
              String brand,
              String idolMemberName) {

  }
}
