package pl.allegro.braincode.team10.service.query.impl;

import org.springframework.stereotype.Service;
import pl.allegro.braincode.team10.allegro.model.ClientData;
import pl.allegro.braincode.team10.allegro.model.DispatchData;
import pl.allegro.braincode.team10.service.query.ClientQueryService;

import java.util.ArrayList;

@Service
public class ClientQueryServiceImpl implements ClientQueryService {
    public void AddClient(ClientData clientData) {

    }
    public ArrayList<DispatchData> GetDispatch(ClientData clientData){
        return new ArrayList<>();
    }
}
