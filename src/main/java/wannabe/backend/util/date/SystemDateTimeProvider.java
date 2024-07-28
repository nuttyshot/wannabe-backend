package wannabe.backend.util.date;

import java.time.Instant;
import org.springframework.stereotype.Service;

@Service
public class SystemDateTimeProvider implements DateTimeProvider {

  @Override
  public long nowTimestamp() {
    return Instant.now().toEpochMilli();
  }
}
