package pl.allegro.braincode.team10.allegro.model;

import pl.allegro.braincode.team10.allegro.dto.Address;

import java.util.ArrayList;

public class ClientDataDummy {
    private ArrayList<String> cities = new ArrayList<>();
    private ArrayList<String> streets = new ArrayList<>();
    private ArrayList<String> post_code = new ArrayList<>();
    private Integer clientID;

    public ClientDataDummy(){
        clientID = 0;

        cities.add("Warsaw");
        cities.add("Cracow");

        streets.add("Jana");
        streets.add("Kazimierza");
        streets.add("Pawla");

        post_code.add("00-001");
        post_code.add("01-010");
        post_code.add("10-100");
    }

    public ClientData getClient(){
        ClientData clientData = new ClientData();

        ++clientID;
        clientData.setClientID(String.valueOf(clientID));
        Address clientAddress = new Address();
        clientAddress.setCity(cities.get(clientID % cities.size()));
        clientAddress.setPostCode(post_code.get(clientID % post_code.size()));
        clientAddress.setStreet(streets.get(clientID % streets.size()));

        clientData.setClientAddresses(clientAddress);

        return clientData;
    }
}
