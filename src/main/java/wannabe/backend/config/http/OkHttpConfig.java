package wannabe.backend.config.http;

import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OkHttpConfig {

  @Bean
  public OkHttpClient okHttpClient() {
    return new OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.SECONDS)
        .callTimeout(10, TimeUnit.SECONDS)
        .connectionPool(new ConnectionPool(10, 5, TimeUnit.MINUTES))
        .build();
  }
}
