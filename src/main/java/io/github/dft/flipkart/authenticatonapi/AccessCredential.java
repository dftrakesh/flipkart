package io.github.dft.flipkart.authenticatonapi;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AccessCredential {

    private String scope;
    private String tokenType;
    private String refreshToken;
    private String accessToken;
    private String clientSecret;
    private String clientId;
    private LocalDateTime expiresIn;
}