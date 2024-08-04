package wannabe.backend.web.init;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wannabe.backend.init.usecase.InitUseCase;

@Hidden
@RestController
@RequestMapping("/init")
@RequiredArgsConstructor
public class InitController {

  private final InitUseCase useCase;

  @GetMapping
  public void init() {
    useCase.execute();
  }
}
