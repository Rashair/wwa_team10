package pl.allegro.braincode.team10.google.service.query;

import pl.allegro.braincode.team10.dto.Address;
import pl.allegro.braincode.team10.google.dtoGoogle.Coordinates;


public interface GoogleQueryService {

    Coordinates getCoordinates(Address address);
}
