package pl.allegro.braincode.team10.google.service.query;

import pl.allegro.braincode.team10.dto.Address;
import pl.allegro.braincode.team10.dto.DeliveryPoint;
import pl.allegro.braincode.team10.google.dtoGoogle.Coordinates;

import java.util.List;


public interface GoogleQueryService {

    Coordinates getCoordinates(Address address);

    void fillDistanceToPoint(List<DeliveryPoint> deliveryPoints, Coordinates coordinates);
}
