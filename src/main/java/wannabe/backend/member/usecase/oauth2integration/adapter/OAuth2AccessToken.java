package wannabe.backend.member.usecase.oauth2integration.adapter;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OAuth2AccessToken(

    @JsonProperty("token_type")
    String tokenType,

    @JsonProperty("access_token")
    String accessToken,

    @JsonProperty("id_token")
    String idToken,

    @JsonProperty("expires_in")
    int expiresIn,

    @JsonProperty("refresh_token")
    String refreshToken,

    @JsonProperty("refresh_token_expires_in")
    int refreshTokenExpiresIn,

    @JsonProperty("scope")
    String scope,

    @JsonProperty("error")
    String error,

    @JsonProperty("error_description")
    String errorDescription,

    @JsonProperty("error_code")
    String errorCode
) {

}
