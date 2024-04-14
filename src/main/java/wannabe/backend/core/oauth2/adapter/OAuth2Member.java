package wannabe.backend.core.oauth2.adapter;

import lombok.NonNull;

public record OAuth2Member(@NonNull String email,
                           @NonNull JoiningStatus joiningStatus) {

}
