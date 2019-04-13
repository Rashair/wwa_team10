package pl.allegro.braincode.team10.google.service.query.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.allegro.braincode.team10.dto.Address;
import pl.allegro.braincode.team10.dto.DeliveryPoint;
import pl.allegro.braincode.team10.exception.GoogleDistancesCalculationException;
import pl.allegro.braincode.team10.exception.SearchingGoogleCoordinatesException;
import pl.allegro.braincode.team10.google.configuration.GoogleConfig;
import pl.allegro.braincode.team10.google.dtoGoogle.*;
import pl.allegro.braincode.team10.google.service.query.GoogleQueryService;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class GoogleQueryServiceImpl implements GoogleQueryService {

    private GoogleConfig config;

    public GoogleQueryServiceImpl(GoogleConfig config) {
        this.config = config;
    }

    @Override
    public Coordinates getCoordinates(Address address) {
        String addressParam = addressPartString(address);
        try {
            RestTemplate restTemplate = new RestTemplate();
            UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(config.getEndpointGeocode())
                    .queryParam(config.getAddressParam(), addressParam)
                    .queryParam(config.getTokenKey(), config.getTokenValue());
            ResponseEntity<CoordinatesAnswer> responseEntity = restTemplate.getForEntity(
                    builder.buildAndExpand(new ArrayList<>()).toUri(), CoordinatesAnswer.class);
            List<AddressData> coordinatesList = responseEntity.getBody().getCoordinatesList();
            if (!coordinatesList.isEmpty()) {
                AddressData addressData = coordinatesList.get(0);
                if (addressData != null && addressData.getGeometry() != null) {
                    return addressData.getGeometry().getCoordinates();
                }
            }
            return null;
        } catch (RestClientException ex) {
            log.error("Error when getting coordinates from address", ex);
            throw new SearchingGoogleCoordinatesException();
        }
    }

    @Override
    public void fillDistanceToPoint(List<DeliveryPoint> deliveryPoints, Coordinates coordinates) {
        if (!deliveryPoints.isEmpty()) {
            StringBuilder strBld = new StringBuilder();
            for (DeliveryPoint deliveryPoint : deliveryPoints) {
                strBld.append(deliveryPoint.getLatitude());
                strBld.append(",");
                strBld.append(deliveryPoint.getLongitude());
                strBld.append("|");
            }
            strBld.deleteCharAt(strBld.length() - 1);
            try {
                RestTemplate restTemplate = new RestTemplate();
                UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(config.getEndpointDistance())
                        .queryParam(config.getOrigins(), coordinates.getLatitude() + "," + coordinates.getLongitude())
                        .queryParam(config.getDestinations(), strBld.toString())
                        .queryParam(config.getTokenKey(), config.getTokenValue());
                ResponseEntity<DistanceRowsList> responseEntity = restTemplate.getForEntity(
                        builder.buildAndExpand(new ArrayList<>()).toUri(), DistanceRowsList.class);
                List<DistanceElement> distanceElementsList = responseEntity
                        .getBody()
                        .getDistanceElementsList()
                        .get(0)
                        .getDistanceElementList();
                for (int i = 0; i < deliveryPoints.size(); ++i) {
                    deliveryPoints.get(i).setDistanceValue(
                            distanceElementsList.get(i).getDistance().getDistanceValue()
                    );
                    deliveryPoints.get(i).setDistanceTextKm(
                            distanceElementsList.get(i).getDistance().getDistTextKm()
                    );
                }
            } catch (RestClientException ex) {
                log.error("Error when getting distances from address", ex);
                throw new GoogleDistancesCalculationException();
            }
        }
    }

    private String addressPartString(Address address) {
        StringBuilder strBld = new StringBuilder();
        if (address != null) {
            if (!isNullOrEmpty(address.getStreet())) {
                strBld.append(" ");
                strBld.append(address.getStreet());
            }
            if (!isNullOrEmpty(address.getBuildingNumber())) {
                strBld.append(" ");
                strBld.append(address.getBuildingNumber());
            }
            if (!isNullOrEmpty(address.getPostCode())) {
                strBld.append(" ");
                strBld.append(address.getPostCode());
            }
            if (!isNullOrEmpty(address.getCity())) {
                strBld.append(" ");
                strBld.append(address.getCity());
            }
            if (strBld.length() != 0) {
                strBld.deleteCharAt(0);
                return strBld.toString();
            } else {
                throw new IllegalArgumentException("Address part was empty");
            }
        } else {
            throw new IllegalArgumentException("Address part was empty");
        }
    }

    private boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }
}
