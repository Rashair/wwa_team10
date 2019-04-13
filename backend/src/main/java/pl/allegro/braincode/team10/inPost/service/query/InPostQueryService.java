package pl.allegro.braincode.team10.inPost.service.query;

import pl.allegro.braincode.team10.dto.DeliveryPoint;
import pl.allegro.braincode.team10.dto.SearchDeliveryPointDTO;
import pl.allegro.braincode.team10.inPost.model.Location;

import java.util.List;

public interface InPostQueryService {
    List<DeliveryPoint> getDeliveryPoints(
            SearchDeliveryPointDTO searchCriteria,
            Location location);
}
