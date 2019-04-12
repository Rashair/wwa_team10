package pl.allegro.braincode.team10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.allegro.braincode.team10.allegro.model.*;
import pl.allegro.braincode.team10.service.query.ClientQueryService;

import java.util.ArrayList;

@RestController
@RequestMapping("")
public class ClientController {

    @Autowired
    public ClientController(ClientQueryService clientQueryService) {
        this.clientQueryService = clientQueryService;
    }

    private ClientQueryService clientQueryService;

    @GetMapping(value = "/client/")
    @ResponseBody
    public ResponseEntity<ArrayList<DispatchData>> apiGet(@RequestBody() ClientData clientData) {
        return new ResponseEntity<> (clientQueryService.GetDispatch(clientData), HttpStatus.OK);
    }

    @PutMapping(value = "/client/address")
    @ResponseBody
    public ResponseEntity<?> apiPut(@RequestBody() ClientData clientData) {
        clientQueryService.AddClient(clientData);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
