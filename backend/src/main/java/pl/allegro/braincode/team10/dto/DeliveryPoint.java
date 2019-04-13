package pl.allegro.braincode.team10.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DeliveryPoint {

    @JsonProperty("name")
    private String name;

    @JsonProperty("latitude")
    private BigDecimal latitude;

    @JsonProperty("longitude")
    private BigDecimal longitude;

    @JsonProperty("address")
    private Address address;

    @JsonProperty("opening_hours")
    private String openingHours;

    @JsonProperty("distance_text")
    private String distanceTextKm;

    @JsonProperty("distance_value")
    private Integer distanceValue;

    @JsonProperty("occupancy")
    private Integer occupancy;

    @JsonProperty("parking")
    private boolean parking;

    @JsonProperty("weekend_pickup")
    private boolean weekendPickup;

    @JsonProperty("time_to_pickup")
    private Integer timeToPickup;

    @JsonProperty("disabled_friendly")
    private boolean disabledFriendly;
}
