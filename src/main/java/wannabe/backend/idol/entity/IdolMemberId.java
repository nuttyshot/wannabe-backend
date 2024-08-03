package wannabe.backend.idol.entity;

public record IdolMemberId(long id) {

  public IdolMemberId {
    if (id <= 0) {
      throw new IllegalArgumentException("아이돌 멤버 ID는 1 이상 이어야 합니다.");
    }
  }
}
