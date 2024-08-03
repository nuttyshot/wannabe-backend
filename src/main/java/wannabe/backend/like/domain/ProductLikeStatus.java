package wannabe.backend.like.domain;

public record ProductLikeStatus(boolean liked) {

  public static ProductLikeStatus notLike() {
    return new ProductLikeStatus(false);
  }
}
