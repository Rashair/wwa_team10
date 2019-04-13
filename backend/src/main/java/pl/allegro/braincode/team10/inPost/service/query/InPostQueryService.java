package pl.allegro.braincode.team10.inPost.service.query;

import pl.allegro.braincode.team10.dto.DeliveryPointBasic;
import pl.allegro.braincode.team10.dto.ListDTO;
import pl.allegro.braincode.team10.dto.SearchDeliveryPointDTO;
import pl.allegro.braincode.team10.inPost.model.Location;

public interface InPostQueryService {
    ListDTO<DeliveryPointBasic> getDeliveryPoints(
            SearchDeliveryPointDTO searchCriteria,
            Location location);
}
