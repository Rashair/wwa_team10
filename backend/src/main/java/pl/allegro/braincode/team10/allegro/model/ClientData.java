package pl.allegro.braincode.team10.allegro.model;

import lombok.Data;
import pl.allegro.braincode.team10.allegro.dto.Address;

import java.util.ArrayList;

@Data
public class ClientData {
    private String clientID;
    private ArrayList<Address> clientAddresses;
}
