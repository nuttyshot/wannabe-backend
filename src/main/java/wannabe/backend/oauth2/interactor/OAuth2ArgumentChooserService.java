package wannabe.backend.oauth2.interactor;

import javax.naming.OperationNotSupportedException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wannabe.backend.oauth2.configuration.OAuth2ArgumentPort;
import wannabe.backend.member.domain.Provider;

@Service
@RequiredArgsConstructor
public class OAuth2ArgumentChooserService {

  private final OAuth2ArgumentPort kakaoArgument;
  private final OAuth2ArgumentPort naverArgument;

  public OAuth2ArgumentPort choose(@NonNull Provider registrationId)
      throws OperationNotSupportedException {

    return switch (registrationId) {
      case KAKAO -> kakaoArgument;
      case NAVER -> naverArgument;
    };
  }
}
