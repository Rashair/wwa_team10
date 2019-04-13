package pl.allegro.braincode.team10.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class NearestDeliveryPointsDTO {

    @JsonProperty("source_latitude")
    private BigDecimal sourceLatitude;

    @JsonProperty("source_longitude")
    private BigDecimal sourceLongitude;

    @JsonProperty("values")
    List<DeliveryPoint> deliveryPointList;
}
