package wannabe.backend.schedule.domain;

public record ScheduleId(long value) {

  public ScheduleId {
    if (value <= 0) {
      throw new IllegalArgumentException("ScheduleId 값은 1 이상 이어야 합니다.");
    }
  }
}
