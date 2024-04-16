package wannabe.backend.core.token;

import java.time.Instant;
import org.springframework.stereotype.Service;

@Service
public class SystemDateTimeProvider implements DateTimeProvider {

  @Override
  public long nowTimestamp() {
    return Instant.now().getEpochSecond();
  }
}
