package pl.allegro.braincode.team10.service.query;

import pl.allegro.braincode.team10.allegro.model.ClientData;
import pl.allegro.braincode.team10.allegro.model.DispatchData;

import java.util.ArrayList;

public interface ClientQueryService {
    void AddClient(ClientData clientData);
    ArrayList<DispatchData> GetDispatch(ClientData clientData);
}
