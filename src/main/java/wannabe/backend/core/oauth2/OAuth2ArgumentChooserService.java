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

  public OAuth2ArgumentPort choose(@NonNull String registrationId)
      throws OperationNotSupportedException {

    if ("kakao".equals(registrationId)) {
      return kakaoArgumentPort;
    }
    if ("naver".equals(registrationId)) {
      return naverArgumentPort;
    }
    throw new OperationNotSupportedException("kakao, naver만 지원합니다.");
  }
}
