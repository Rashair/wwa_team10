package pl.allegro.braincode.team10.google.dtoGoogle;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Geometry {
    @JsonProperty("location")
    private Coordinates coordinates;
}