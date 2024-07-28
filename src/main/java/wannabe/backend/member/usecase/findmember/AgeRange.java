package wannabe.backend.member.usecase.findmember;

public enum AgeRange {
  UNDER_TEN("10세 미만"),
  TEENS("10세 이상 20세 미만"),
  TWENTIES("20세 이상 30세 미만"),
  THIRTIES("30세 이상 40세 미만"),
  FORTIES("40세 이상 50세 미만"),
  FIFTIES("50세 이상 60세 미만"),
  OVER_SIXTY("60세 이상");


  private final String description;

  AgeRange(String description) {
    this.description = description;
  }

  public static AgeRange fromKakaoString(String ageRange) {
    if (ageRange == null) {
      return null;
    }

    return switch (ageRange) {
      case "1~9" -> UNDER_TEN;
      case "10~14" -> TEENS;
      case "15~19" -> TEENS;
      case "20~29" -> TWENTIES;
      case "30~39" -> THIRTIES;
      case "40~49" -> FORTIES;
      case "50~59" -> FIFTIES;
      case "60~69", "70~79", "80~89", "90~" -> OVER_SIXTY;
      default -> throw new IllegalArgumentException("유효하지 않은 연령대입니다 : " + ageRange);
    };
  }

  public static AgeRange fromNaverString(String ageRange) {
    if (ageRange == null) {
      return null;
    }

    return switch (ageRange) {
      case "0-9" -> UNDER_TEN;
      case "10-19" -> TEENS;
      case "20-29" -> TWENTIES;
      case "30-39" -> THIRTIES;
      case "40-49" -> FORTIES;
      case "50-59" -> FIFTIES;
      case "60-" -> OVER_SIXTY;
      default -> throw new IllegalArgumentException("유효하지 않은 연령대입니다 : " + ageRange);
    };
  }
}
