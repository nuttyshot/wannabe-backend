package wannabe.backend.core.oauth2.adapter;

import java.util.Map;
import lombok.NonNull;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
public class OAuth2MemberFactory {

  public OAuth2Member create(@NonNull String registrationId, @NonNull Map<String, Object> resBody) {
    return switch (registrationId) {
      case "kakao" -> kakao(resBody);
      case "naver" -> naver(resBody);
      default ->
          throw new IllegalArgumentException("registrationId는 kakao만 가능합니다 : " + registrationId);
    };
  }

  // {"resultcode":"00","message":"success","response":{"id":"IbYfZMcXYR16BJtdHC7uhxhbSWtvr-r_81QZn6dkQ7Y","nickname":"\uc9c0\uc6d0","age":"20-29","email":"hoho1911@naver.com","birthday":"05-18","birthyear":"1996"}}
  private OAuth2Member naver(@NonNull Map<String, Object> resBody) {

    // naver 에서 오는 response는 Map<String, Object> 형태이다.
    @SuppressWarnings("unchecked")
    val response = (Map<String, Object>) resBody.getOrDefault("response", Map.of());

    val name = (String) response.getOrDefault("name", null);
    val nickname = (String) response.getOrDefault("nickname", null);
    val age = (String) response.getOrDefault("age", null);
    val email = (String) response.getOrDefault("email", null);
    val birthday = (String) response.getOrDefault("birthday", null);
    val birthyear = (String) response.getOrDefault("birthyear", null);
    val mobile = (String) response.getOrDefault("mobile", null);

    return OAuth2Member.builder()
        .email(email)
        .birthyear(birthyear) // YYYY
        .nickname(nickname)
        .name(name)
        .ageRange(age)
        .birthday(birthday) // MMDD
        .phoneNo(mobile)
        .build();
  }

  // resBody = {id=3437034292, connected_at=2024-04-14T17:48:51Z, synched_at=2024-04-14T17:48:51Z, properties={nickname=지원}, kakao_account={profile_nickname_needs_agreement=false, profile={nickname=지원, is_default_nickname=false}, name_needs_agreement=false, name=안지원, has_email=true, email_needs_agreement=false, is_email_valid=true, is_email_verified=true, email=hoho1911@naver.com, has_phone_number=true, phone_number_needs_agreement=false, phone_number=+82 10-2931-5201, has_age_range=true, age_range_needs_agreement=false, age_range=20~29, has_birthyear=true, birthyear_needs_agreement=false, birthyear=1996, has_birthday=true, birthday_needs_agreement=false, birthday=0518, birthday_type=SOLAR}}
  private OAuth2Member kakao(@NonNull Map<String, Object> resBody) {

    // kakao 에서 오는 kakao_account은 Map<String, Object> 형태이다.
    @SuppressWarnings("unchecked")
    val kakaoAccount = (Map<String, Object>) resBody.getOrDefault("kakao_account", Map.of());

    // profile은 Map<String, Object> 형태이다.
    @SuppressWarnings("unchecked")
    val profile = (Map<String, Object>) kakaoAccount.getOrDefault("profile", Map.of());

    val email = (String) kakaoAccount.getOrDefault("email", null);
    val birthyear = (String) kakaoAccount.getOrDefault("birthyear", null);
    val nickname = (String) profile.getOrDefault("nickname", null);
    val name = (String) kakaoAccount.getOrDefault("name", null);
    val ageRange = (String) kakaoAccount.getOrDefault("age_range", null);
    val birthday = (String) kakaoAccount.getOrDefault("birthday", null);
    val phoneNo = (String) kakaoAccount.getOrDefault("phone_number", null);

    return OAuth2Member.builder()
        .email(email)
        .birthyear(birthyear) // YYYY
        .nickname(nickname)
        .name(name)
        .ageRange(ageRange)
        .birthday(birthday) // MMDD
        .phoneNo(phoneNo)
        .build();
  }
}
