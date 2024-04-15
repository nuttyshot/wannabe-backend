package wannabe.backend.core.oauth2.redirectpages;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FrontBaseUrlArgument implements FrontBaseUrlArgumentGateway {

  @Value("${domain.front.mobile}")
  private String mobile;

  @Override
  public String mobile() {
    return mobile;
  }
}
