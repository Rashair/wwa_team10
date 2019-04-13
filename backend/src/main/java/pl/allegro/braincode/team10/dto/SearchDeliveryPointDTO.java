package pl.allegro.braincode.team10.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SearchDeliveryPointDTO {

    @JsonProperty("address")
    Address address;

    @JsonProperty("max_distance")
    private Integer maxDistance;

    @JsonProperty("parking")
    private Boolean parking;

    @JsonProperty("weekend_pickup")
    private Boolean weekendPickup;

    @JsonProperty("time_to_pickup")
    private Integer timeToPickup;

    @JsonProperty("disabled_friendly")
    private Boolean disabledFriendly;
}
