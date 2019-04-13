package pl.allegro.braincode.team10.allegro.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PointIn {
    @JsonProperty("clientAddresses")
    private List<Address> clientAddresses;
}
