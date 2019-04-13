package pl.allegro.braincode.team10.service.query;

import pl.allegro.braincode.team10.allegro.dto.Address;

import java.util.ArrayList;
import java.util.List;

public interface ClientQueryService {

    void addClient(String clientID, Address clientAddresses);

    Address getClientAddress(String clientID);
}
