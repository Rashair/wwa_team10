package pl.allegro.braincode.team10.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.allegro.braincode.team10.dto.DeliveryPoint;
import pl.allegro.braincode.team10.dto.NearestDeliveryPointsDTO;
import pl.allegro.braincode.team10.dto.SearchDeliveryPointDTO;
import pl.allegro.braincode.team10.google.dtoGoogle.Coordinates;
import pl.allegro.braincode.team10.google.service.query.GoogleQueryService;
import pl.allegro.braincode.team10.inPost.model.Location;
import pl.allegro.braincode.team10.inPost.service.query.InPostQueryService;
import pl.allegro.braincode.team10.mapper.CoordinatesMapper;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    private InPostQueryService inPostQueryService;

    private GoogleQueryService googleQueryService;

    private CoordinatesMapper coordinatesMapper;

    public DeliveryController(
            InPostQueryService inPostQueryService,
            GoogleQueryService googleQueryService,
            CoordinatesMapper coordinatesMapper) {
        this.inPostQueryService = inPostQueryService;
        this.googleQueryService = googleQueryService;
        this.coordinatesMapper = coordinatesMapper;
    }

    @PostMapping
    public ResponseEntity<NearestDeliveryPointsDTO> getDeliveryPoints(
            @RequestBody(required = true) SearchDeliveryPointDTO searchDeliveryPointDTO) {
        //walidacja danych
        Coordinates coordinates = this.googleQueryService.getCoordinates(searchDeliveryPointDTO.getAddress());
        Location location = this.coordinatesMapper.coordinatesToLocation(coordinates);
        List<DeliveryPoint> deliveryPoints = this.inPostQueryService.getDeliveryPoints(searchDeliveryPointDTO, location);
        this.googleQueryService.fillDistanceToPoint(deliveryPoints, coordinates);
        Collections.sort(deliveryPoints, Comparator.comparing(DeliveryPoint::getDistanceValue));
        NearestDeliveryPointsDTO nearestDeliveryPointsDTO = new NearestDeliveryPointsDTO();
        nearestDeliveryPointsDTO.setDeliveryPointList(deliveryPoints);
        nearestDeliveryPointsDTO.setSourceLatitude(location.getLatitude());
        nearestDeliveryPointsDTO.setSourceLongitude(location.getLongitude());
        return new ResponseEntity<>(nearestDeliveryPointsDTO, HttpStatus.OK);
    }
}