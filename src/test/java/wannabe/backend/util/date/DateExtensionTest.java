package wannabe.backend.util.date;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import lombok.experimental.ExtensionMethod;
import lombok.val;
import org.junit.jupiter.api.Test;
import wannabe.backend.util.date.DateExtension;

@ExtensionMethod(DateExtension.class)
class DateExtensionTest {

  @Test
  void 날짜가_포맷대로_파싱되어야한다() {
    // given
    // when
    val date = "20200101".toLocalDate("yyyyMMdd");
    // then
    assertThat(date).isEqualTo(LocalDate.of(2020, 1, 1));
  }
}