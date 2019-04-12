package pl.allegro.braincode.team10.dto;

import org.springframework.web.bind.annotation.*;

@RestController
public class PointBasic {
    @GetMapping(value = "/client/")
    @ResponseBody
    public String apiGet() {

    }

    @PutMapping(value = "/client/address")
    @ResponseBody
    public String apiPut() {

    }
}
