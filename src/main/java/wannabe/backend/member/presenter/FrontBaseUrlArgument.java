package wannabe.backend.member.presenter;

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
