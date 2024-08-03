package wannabe.backend.member.domain.factory;

import static wannabe.backend.member.domain.Provider.KAKAO;
import static wannabe.backend.member.domain.Provider.NAVER;

import java.util.EnumMap;
import java.util.Map;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import wannabe.backend.member.domain.Provider;

@Service
public class MemberFactoryProvider {

  private final Map<Provider, MemberFactory> memberFactories;

  public MemberFactoryProvider(MemberFactory kakaoMemberFactory,
      MemberFactory naverMemberFactory) {
    this.memberFactories = new EnumMap<>(Provider.class);
    this.memberFactories.put(KAKAO, kakaoMemberFactory);
    this.memberFactories.put(NAVER, naverMemberFactory);
  }

  public MemberFactory getMemberFactory(@NonNull Provider provider) {
    return memberFactories.get(provider);
  }
}
