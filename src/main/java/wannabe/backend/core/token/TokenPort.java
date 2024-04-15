package wannabe.backend.core.token;

import lombok.NonNull;

public interface TokenPort {

  LoginToken loginToken(@NonNull TokenInformation tokenInformation);
}
