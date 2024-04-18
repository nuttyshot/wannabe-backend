package wannabe.backend.core.oauth2;

import static wannabe.backend.core.oauth2.Provider.*;

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

    if (KAKAO == registrationId) {
      return kakaoArgumentPort;
    }
    if (NAVER == registrationId) {
      return naverArgumentPort;
    }
    throw new OperationNotSupportedException("kakao, naver만 지원합니다.");
  }
}
