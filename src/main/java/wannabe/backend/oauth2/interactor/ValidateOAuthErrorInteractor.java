package wannabe.backend.oauth2.interactor;

import java.util.Map;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wannabe.backend.oauth2.usecase.ValidateOAuth2ErrorUseCase;
import wannabe.backend.member.domain.Provider;

@Service
@Slf4j
public class ValidateOAuthErrorInteractor implements ValidateOAuth2ErrorUseCase {

  @Override
  public void receive(@NonNull Provider registrationId, int status,
      @NonNull Map<String, Object> resBody) {

    if (status == 200) {
      return;
    }

    log.error("OAuth2 로그인 후 사용자 정보 가져오는 과정에 에러 발생 provider : %s, body : %s".formatted(
        registrationId, resBody));

    switch (registrationId) {
      case KAKAO -> handleKakaoError();
      case NAVER -> handleNaverError();
    }
  }

  private void handleNaverError() {
    throw new OAuth2NetworkException("naver 로그인에 실패했습니다. 계속 문제가 반복되면 고객센터에 연락해주세요.");
  }

  private void handleKakaoError() {
    throw new OAuth2NetworkException("kakao 로그인에 실패했습니다. 계속 문제가 반복되면 고객센터에 연락해주세요.");
  }
}
