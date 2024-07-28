package wannabe.backend.member.usecase.oauth2integration.port;

public class OAuth2NetworkException extends IllegalStateException {

  public OAuth2NetworkException(String message) {
    super(message);
  }
}
