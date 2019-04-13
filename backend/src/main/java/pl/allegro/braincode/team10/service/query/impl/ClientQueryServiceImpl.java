package pl.allegro.braincode.team10.service.query.impl;

import org.springframework.stereotype.Service;
import pl.allegro.braincode.team10.allegro.dto.Address;
import pl.allegro.braincode.team10.allegro.model.ClientData;
import pl.allegro.braincode.team10.allegro.model.ClientDataDummy;
import pl.allegro.braincode.team10.service.query.ClientQueryService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientQueryServiceImpl implements ClientQueryService {

    public ClientQueryServiceImpl() {


        //Adding some clients to list
        ClientDataDummy clientData = new ClientDataDummy();
        for(int i = 0; i < 10; ++i){
            this.clients.add(clientData.getClient());
        }
    }

    public void addClient(String clientID, Address clientAddresses) {

        ClientData clientData = new ClientData();
        clientData.setClientAddresses(clientAddresses);
        clientData.setClientID(clientID);

        this.clients.add(clientData);
    }

    public Address getClientAddress(String clientID){
        for (ClientData cd : clients) {
            if(cd.getClientID().equals(clientID)){
                return cd.getClientAddresses();
            }
        }
        return new Address();
    }

    private ArrayList<ClientData> clients = new ArrayList<>();
}
