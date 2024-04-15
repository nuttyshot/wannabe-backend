package wannabe.backend.core.token;

import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class TokenInterator implements TokenPort {

  @Override
  public LoginToken loginToken(@NonNull TokenInformation tokenInformation) {
    return null;
  }
}
