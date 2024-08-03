package wannabe.backend.idol.domain;

public record IdolGroupId(long value) {

  public IdolGroupId {
    if (value <= 0) {
      throw new IllegalArgumentException("IdolGroupId은 1 이상 이어야 합니다.");
    }
  }
}
