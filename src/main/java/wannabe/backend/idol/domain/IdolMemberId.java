package wannabe.backend.idol.domain;

public record IdolMemberId(long value) {

  public IdolMemberId {
    if (value <= 0) {
      throw new IllegalArgumentException("아이돌 멤버 ID는 1 이상 이어야 합니다.");
    }
  }
}
