package pl.allegro.braincode.team10.service.query.impl;

import org.springframework.stereotype.Service;
import pl.allegro.braincode.team10.allegro.dto.Address;
import pl.allegro.braincode.team10.allegro.model.ClientData;
import pl.allegro.braincode.team10.service.query.ClientQueryService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientQueryServiceImpl implements ClientQueryService {
    public void addClient(String clientID, List<Address> clientAddresses) {

        ClientData clientData = new ClientData();
        clientData.setClientAddresses(new ArrayList<>(clientAddresses));
        clientData.setClientID(clientID);

        this.clients.add(clientData);
    }
    public ArrayList<Address> getClientAddress(String clientID){
        for (ClientData cd : clients) {
            if(cd.getClientID().equals(clientID)){
                return cd.getClientAddresses();
            }
        }
        return new ArrayList<>();
    }

    private ArrayList<ClientData> clients = new ArrayList<>();
}
