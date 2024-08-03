package wannabe.backend.member.domain;

public record MemberId(long value) {

  public MemberId {
    if (value <= 0) {
      throw new IllegalArgumentException("MemberId는 1 이상 이어야 합니다.");
    }
  }
}
