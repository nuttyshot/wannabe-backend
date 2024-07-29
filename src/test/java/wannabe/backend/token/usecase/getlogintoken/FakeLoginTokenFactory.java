package wannabe.backend.token.usecase.getlogintoken;

public class FakeLoginTokenFactory {

  public static LoginToken create() {
    return LoginToken.builder()
        .accessToken("MOCK_ACCESS_TOKEN")
        .refreshToken("MOCK_REFRESH_TOKEN")
        .expiredAt(0L)
        .build();
  }
}
