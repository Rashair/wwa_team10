package pl.allegro.braincode.team10.allegro.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ClientAddressDTO {
    @JsonProperty("clientAddresses")
    private Address clientAddresses;
}
