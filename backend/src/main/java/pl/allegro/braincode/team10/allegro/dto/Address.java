package pl.allegro.braincode.team10.allegro.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Address {

    @JsonProperty("city")
    String city;

    @JsonProperty("province")
    String province;

    @JsonProperty("post_code")
    String postCode;

    @JsonProperty("street")
    String street;

    @JsonProperty("building_number")
    String buildingNumber;

    @JsonProperty("flat_number")
    String flatNumber;
}
