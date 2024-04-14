package wannabe.backend.core.oauth2;

import javax.naming.OperationNotSupportedException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OAuth2ArgumentChooserService {

  @Qualifier(value = "kakaoArgumentPort")
  private final OAuth2ArgumentPort kakaoArgumentPort;

  public OAuth2ArgumentPort choose(@NonNull String registrationId)
      throws OperationNotSupportedException {

    if ("kakao".equals(registrationId)) {
      return kakaoArgumentPort;
    }
    throw new OperationNotSupportedException("kakao만 지원합니다.");
  }
}
