package pl.allegro.braincode.team10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.allegro.braincode.team10.model.DeliveryPointData;

import java.util.List;

public interface DeliveryPointDataRepository extends JpaRepository<DeliveryPointData, Integer> {

    @Query("SELECT dpd from DeliveryPointData dpd where dpd.inpostId IN :inPostIDs")
    List<DeliveryPointData> findByInPostIDs(List<String> inPostIDs);
}
