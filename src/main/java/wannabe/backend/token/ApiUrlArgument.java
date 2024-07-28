package wannabe.backend.token;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ApiUrlArgument implements ApiUrlArgumentGateway {

  @Value("${domain.backend}")
  private String apiUrl;

  @Override
  public String getApiUrl() {
    return apiUrl;
  }
}
