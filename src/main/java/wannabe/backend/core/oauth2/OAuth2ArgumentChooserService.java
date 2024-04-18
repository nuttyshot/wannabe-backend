package wannabe.backend.core.oauth2;

import javax.naming.OperationNotSupportedException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OAuth2ArgumentChooserService {

  private final OAuth2ArgumentPort kakaoArgumentPort;
  private final OAuth2ArgumentPort naverArgumentPort;

  public OAuth2ArgumentPort choose(@NonNull Provider registrationId)
      throws OperationNotSupportedException {

    return switch (registrationId) {
      case KAKAO -> kakaoArgumentPort;
      case NAVER -> naverArgumentPort;
    };
  }
}
