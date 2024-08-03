package wannabe.backend.member.domain;

public record MemberId(Long value) {

  public MemberId {
    if (value != null && value <= 0) {
      throw new IllegalArgumentException("MemberId는 1 이상 이어야 합니다.");
    }
  }
}
