package pl.allegro.braincode.team10.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DeliveryPointBasic {

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
}
