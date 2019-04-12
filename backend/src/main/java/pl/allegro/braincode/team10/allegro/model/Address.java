package pl.allegro.braincode.team10.allegro.model;

import lombok.Data;

@Data
public class Address {
    private String street;
    private String city;
    private Integer postCode;
    private String flatNumber;
}
