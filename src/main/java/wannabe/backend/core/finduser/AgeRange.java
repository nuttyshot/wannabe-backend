package wannabe.backend.core.finduser;

public enum AgeRange {
  AGE_1_9("1세 이상 10세 미만"),
  AGE_10_14("10세 이상 15세 미만"),
  AGE_15_19("15세 이상 20세 미만"),
  AGE_20_29("20세 이상 30세 미만"),
  AGE_30_39("30세 이상 40세 미만"),
  AGE_40_49("40세 이상 50세 미만"),
  AGE_50_59("50세 이상 60세 미만"),
  AGE_60_69("60세 이상 70세 미만"),
  AGE_70_79("70세 이상 80세 미만"),
  AGE_80_89("80세 이상 90세 미만"),
  AGE_90("90세 이상");

  private final String description;

  AgeRange(String description) {
    this.description = description;
  }
}
