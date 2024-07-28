package wannabe.backend.core.token;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import wannabe.backend.util.date.SystemDateTimeProvider;

@ExtendWith(MockitoExtension.class)
class SystemDateTimeProviderTest {

  @InjectMocks
  private SystemDateTimeProvider provider;

  @Test
  void 시스템_timestamp_반환() {
    // given
    val now = LocalDateTime.now();
    // when
    val timestamp = provider.nowTimestamp();
    // then
    val timestampToLocalDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp),
        ZoneId.systemDefault());
    assertThat(timestampToLocalDateTime.withNano(0)).isEqualTo(now.withNano(0));
  }
}