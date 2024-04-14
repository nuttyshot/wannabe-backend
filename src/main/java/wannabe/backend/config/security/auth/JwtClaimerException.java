package wannabe.backend.config.security.auth;

public class JwtClaimerException extends IllegalArgumentException {

  private final String code;

  public JwtClaimerException(String message, Throwable cause, String code) {
    super(message, cause);

    this.code = code;
  }
}
