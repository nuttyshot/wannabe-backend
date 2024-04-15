package wannabe.backend.core.oauth2.adapter;

import java.util.Map;
import lombok.NonNull;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
public class OAuth2MemberFactory {

  public OAuth2Member create(@NonNull String registrationId, @NonNull Map<String, Object> resBody) {
    return switch (registrationId) {
      case "kakao" -> kakao(registrationId, resBody);
      default ->
          throw new IllegalArgumentException("registrationId는 kakao만 가능합니다 : " + registrationId);
    };
  }

  // resBody = {id=3437034292, connected_at=2024-04-14T17:48:51Z, synched_at=2024-04-14T17:48:51Z, properties={nickname=지원}, kakao_account={profile_nickname_needs_agreement=false, profile={nickname=지원, is_default_nickname=false}, name_needs_agreement=false, name=안지원, has_email=true, email_needs_agreement=false, is_email_valid=true, is_email_verified=true, email=hoho1911@naver.com, has_phone_number=true, phone_number_needs_agreement=false, phone_number=+82 10-2931-5201, has_age_range=true, age_range_needs_agreement=false, age_range=20~29, has_birthyear=true, birthyear_needs_agreement=false, birthyear=1996, has_birthday=true, birthday_needs_agreement=false, birthday=0518, birthday_type=SOLAR}}
  private OAuth2Member kakao(@NonNull String registrationId,
      @NonNull Map<String, Object> resBody) {

    // kakao 에서 오는 kakao_account은 Map<String, Object> 형태이다.
    @SuppressWarnings("unchecked")
    val kakaoAccount = (Map<String, Object>) resBody.get("kakao_account");

    val email = kakaoAccount.getOrDefault("email", "").toString();
    val birthyear = kakaoAccount.getOrDefault("birthyear", "").toString();
    val nickname = kakaoAccount.getOrDefault("nickname", "").toString();
    val name = kakaoAccount.getOrDefault("name", "").toString();
    val ageRange = kakaoAccount.getOrDefault("age_range", "").toString();
    val birthday = kakaoAccount.getOrDefault("birthday", "").toString();
    val phoneNo = kakaoAccount.getOrDefault("phone_number", "").toString();

    return OAuth2Member.builder()
        .email(email)
        .birthyear(birthyear) // YYYY
        .nickname(nickname)
        .name(name)
        .ageRange(ageRange)
        .birthday(birthday) // MMDD
        .phoneNo(phoneNo)
        .provider(registrationId)
        .build();
  }
}
