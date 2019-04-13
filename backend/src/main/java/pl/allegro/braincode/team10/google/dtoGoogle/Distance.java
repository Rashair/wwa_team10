package pl.allegro.braincode.team10.google.dtoGoogle;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Distance {

    @JsonProperty("text")
    String distTextKm;

    /**
     * Distance in meters
     */
    @JsonProperty("value")
    Integer distanceValue;
}
