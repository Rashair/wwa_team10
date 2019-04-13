package pl.allegro.braincode.team10.google.dtoGoogle;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Coordinates {
    @JsonProperty("lat")
    BigDecimal latitude;
    @JsonProperty("lng")
    BigDecimal longitude;
}
