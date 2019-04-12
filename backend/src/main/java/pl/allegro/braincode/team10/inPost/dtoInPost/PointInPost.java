package pl.allegro.braincode.team10.inPost.dtoInPost;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import pl.allegro.braincode.team10.inPost.model.Address;
import pl.allegro.braincode.team10.inPost.model.Location;
import pl.allegro.braincode.team10.inPost.model.Type;

import java.util.List;

@Data
public class PointInPost {
    @JsonProperty("href")
    private String uriAddress;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private List<Type> type;

    @JsonProperty("location")
    private Location location;

    @JsonProperty("location_description")
    private String locationDescription;

    @JsonProperty("opening_hours")
    private String openingHours;

    @JsonProperty("address_details")
    private Address address;

    @JsonProperty("phone_number")
    private String phoneNumber;
}
