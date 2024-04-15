package wannabe.backend.core.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateExtension {

  private DateExtension() {
  }

  public static LocalDate toLocalDate(final String date, final String format) {
    return LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
  }
}
