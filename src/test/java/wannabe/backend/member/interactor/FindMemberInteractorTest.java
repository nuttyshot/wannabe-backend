package wannabe.backend.member.interactor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import wannabe.backend.member.domain.Member;
import wannabe.backend.member.gateway.FindMemberDsGateway;

@ExtendWith(MockitoExtension.class)
class FindMemberInteractorTest {

  @InjectMocks
  private FindMemberInteractor interactor;

  @Mock
  private FindMemberDsGateway gateway;

  @Test
  void 이메일로_회원_찾기() {
    // given
    when(gateway.findByEmail(any())).thenReturn(Optional.of(member()));
    // when
    val findMember = interactor.execute("MOCK_EMAIL").get();
    // then
    assertThat(findMember).isNotNull();
  }

  private static Member member() {
    return Member.builder().build();
  }
}