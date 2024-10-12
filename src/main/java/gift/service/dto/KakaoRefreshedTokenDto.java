package gift.service.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record KakaoRefreshedTokenDto(
    String accessToken,
    String tokenType,
    Long expiresIn
) {

}
