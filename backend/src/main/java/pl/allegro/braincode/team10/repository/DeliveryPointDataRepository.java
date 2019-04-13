package pl.allegro.braincode.team10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.allegro.braincode.team10.model.DeliveryPointData;

public interface DeliveryPointDataRepository extends JpaRepository<DeliveryPointData, Integer> {
}
