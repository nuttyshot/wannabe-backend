package wannabe.backend.core.token;

import lombok.Getter;

public record TokenInformation(long memberId) {

  public enum TokenKey {

    MEMBER_ID_KEY("memberId");

    @Getter
    private final String value;

    TokenKey(String value) {
      this.value = value;
    }
  }
}
