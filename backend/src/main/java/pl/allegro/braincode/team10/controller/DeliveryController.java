package pl.allegro.braincode.team10.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.allegro.braincode.team10.dto.DeliveryPointBasic;
import pl.allegro.braincode.team10.dto.ListDTO;
import pl.allegro.braincode.team10.inPost.service.command.InPostCommandService;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    private InPostCommandService inPostCommandService;

    public DeliveryController(InPostCommandService inPostCommandService) {
        this.inPostCommandService = inPostCommandService;
    }

    @GetMapping
    public ResponseEntity<ListDTO<DeliveryPointBasic>> test() {
        ListDTO listDTO = this.inPostCommandService.test();
        return new ResponseEntity<>(listDTO, HttpStatus.OK);
    }

}