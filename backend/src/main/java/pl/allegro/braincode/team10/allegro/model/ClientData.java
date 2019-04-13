package pl.allegro.braincode.team10.allegro.model;

import lombok.Data;
import pl.allegro.braincode.team10.allegro.dto.Address;

@Data
public class ClientData {
    private String clientID;
    private Address clientAddresses;
}
