package pl.allegro.braincode.team10.allegro.model;

import pl.allegro.braincode.team10.allegro.dto.Address;

import java.util.ArrayList;

public class ClientDataDummy {
    private ArrayList<String> cities = new ArrayList<>();
    private ArrayList<String> streets = new ArrayList<>();
    private ArrayList<String> post_code = new ArrayList<>();
    private ArrayList<String> building_number = new ArrayList<>();
    private ArrayList<String> flat_number = new ArrayList<>();
    private Integer clientID;

    public ClientDataDummy(){
        clientID = 0;

        cities.add("Warszawa");

        streets.add("Jana Pawla 2");

        building_number.add("22");

        flat_number.add("1");

        post_code.add("00-001");
    }

    public ClientData getClient(){
        ClientData clientData = new ClientData();

        ++clientID;
        clientData.setClientID(String.valueOf(clientID));
        Address clientAddress = new Address();
        clientAddress.setCity(cities.get(clientID % cities.size()));
        clientAddress.setPostCode(post_code.get(clientID % post_code.size()));
        clientAddress.setStreet(streets.get(clientID % streets.size()));
        clientAddress.setBuildingNumber(building_number.get(clientID % building_number.size()));
        clientAddress.setFlatNumber(flat_number.get(clientID % flat_number.size()));
        
        clientData.setClientAddresses(clientAddress);

        return clientData;
    }
}
