package pl.allegro.braincode.team10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.allegro.braincode.team10.allegro.dto.Address;
import pl.allegro.braincode.team10.allegro.dto.ClientAddressDTO;
import pl.allegro.braincode.team10.service.query.ClientQueryService;

import java.util.ArrayList;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    public ClientController(ClientQueryService clientQueryService) {

        this.clientQueryService = clientQueryService;

    }

    private ClientQueryService clientQueryService;

    @GetMapping(value = "/{id}/address")
    @ResponseBody
    public ResponseEntity<Address> getClientAddresses(@PathVariable("id") String clientID) {

        Address clientAddresses =  clientQueryService.getClientAddress(clientID);

        return new ResponseEntity<> (clientAddresses, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}/address")
    @ResponseBody
    public ResponseEntity<?> putClientAddresses(@PathVariable("id") String clientID, @RequestBody() ClientAddressDTO clientAddresses) {

        clientQueryService.addClient(clientID, clientAddresses.getClientAddresses());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
