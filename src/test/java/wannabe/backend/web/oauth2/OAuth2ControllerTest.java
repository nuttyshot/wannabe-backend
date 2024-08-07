package wannabe.backend.web.oauth2;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static wannabe.backend.member.domain.Provider.*;

import java.util.List;
import javax.naming.OperationNotSupportedException;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import wannabe.backend.oauth2.interactor.OAuth2ArgumentChooserService;
import wannabe.backend.oauth2.configuration.OAuth2ArgumentPort;
import wannabe.backend.member.domain.OAuth2ProviderValues;
import wannabe.backend.member.domain.OAuth2ProviderValues.Provider;
import wannabe.backend.member.domain.OAuth2ProviderValues.Registration;

@ExtendWith(MockitoExtension.class)
class OAuth2ControllerTest {

  @InjectMocks
  private OAuth2Controller controller;

  @Mock
  private OAuth2ArgumentChooserService oAuth2ArgumentChooserService;

  @Test
  void redirect_uri_정상_생성() throws OperationNotSupportedException {
    // given
    val argumentPort = mock(OAuth2ArgumentPort.class);
    when(oAuth2ArgumentChooserService.choose(any())).thenReturn(argumentPort);
    when(argumentPort.client()).thenReturn(oAuth2ProviderValues());
    // when
    val redirectView = controller.kakao();
    // then
    assertThat(redirectView.getUrl()).contains("KAKAO");

    verify(oAuth2ArgumentChooserService, only()).choose(KAKAO);
  }

  @Test
  void chooser호출중_OperationNotSupportedException_발생시_IllegalArgumentException으로_던진다()
      throws OperationNotSupportedException {
    // given
    when(oAuth2ArgumentChooserService.choose(any())).thenThrow(
        OperationNotSupportedException.class);
    // when
    // then
    assertThrows(IllegalArgumentException.class, () -> controller.kakao());
  }

  private OAuth2ProviderValues oAuth2ProviderValues() {
    return OAuth2ProviderValues.builder()
        .registration(Registration.builder()
            .scope(List.of("MOCK_SCOPE1"))
            .build())
        .provider(Provider.builder().build())
        .build();
  }
}