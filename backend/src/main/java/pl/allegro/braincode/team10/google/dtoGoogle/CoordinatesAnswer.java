package pl.allegro.braincode.team10.google.dtoGoogle;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CoordinatesAnswer {
    @JsonProperty("results")
    List<AddressData> coordinatesList;
}
