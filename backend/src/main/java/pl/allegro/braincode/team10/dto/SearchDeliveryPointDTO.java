package pl.allegro.braincode.team10.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SearchDeliveryPointDTO {

    @JsonProperty("address")
    Address address;

    @JsonProperty("max_distance")
    private Integer maxDistance;
}
