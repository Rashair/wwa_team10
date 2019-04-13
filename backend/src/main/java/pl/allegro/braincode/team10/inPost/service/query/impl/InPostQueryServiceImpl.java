package pl.allegro.braincode.team10.inPost.service.query.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.allegro.braincode.team10.dto.DeliveryPoint;
import pl.allegro.braincode.team10.dto.SearchDeliveryPointDTO;
import pl.allegro.braincode.team10.exception.SearchingInPostDeliveryException;
import pl.allegro.braincode.team10.inPost.dtoInPost.PointInPost;
import pl.allegro.braincode.team10.inPost.dtoInPost.PointsList;
import pl.allegro.braincode.team10.inPost.model.Location;
import pl.allegro.braincode.team10.inPost.service.query.InPostQueryService;
import pl.allegro.braincode.team10.mapper.PointInPostMapper;
import pl.allegro.braincode.team10.model.DeliveryPointData;
import pl.allegro.braincode.team10.repository.DeliveryPointDataRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class InPostQueryServiceImpl implements InPostQueryService {

    private PointInPostMapper pointInPostMapper;

    private DeliveryPointDataRepository deliveryPointDataRepository;

    private final static String ENDPOINT_GET_POINTS = "https://api-shipx-pl.easypack24.net/v1/points";

    private final static String DEFAULT_MAX_DISTANCE = "2000";

    public InPostQueryServiceImpl(
            PointInPostMapper pointInPostMapper,
            DeliveryPointDataRepository deliveryPointDataRepository) {
        this.pointInPostMapper = pointInPostMapper;
        this.deliveryPointDataRepository = deliveryPointDataRepository;
    }

    @Override
    public List<DeliveryPoint> getDeliveryPoints(
            SearchDeliveryPointDTO searchCriteria,
            Location location) {
        validateLocation(location);
        try {
            List<PointInPost> pointInPostListAll = new ArrayList<>();
            RestTemplate restTemplate = new RestTemplate();
            Map<String, String> paramsAdd = parseSearchCriteria(searchCriteria);
            UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(ENDPOINT_GET_POINTS)
                    .queryParam("fields", "href,name,type,location,location_description,opening_hours,address_details,phone_number")
                    .queryParam("page", "1")
                    .queryParam("relative_point", location.getLatitude() + "," + location.getLongitude());
            for (Map.Entry<String, String> entry : paramsAdd.entrySet()) {
                builder.queryParam(entry.getKey(), entry.getValue());
            }
            ResponseEntity<PointsList> responseEntity = restTemplate.getForEntity(builder.buildAndExpand(new ArrayList<>()).toUri(), PointsList.class);
            PointsList pointsList = responseEntity.getBody();
            pointInPostListAll.addAll(pointsList.getPointsList());
            for (int i = 2; i <= pointsList.getTotalPages(); ++i) {
                builder.replaceQueryParam("page", String.valueOf(i));
                responseEntity = restTemplate.getForEntity(builder.buildAndExpand(new ArrayList<>()).toUri(), PointsList.class);
                pointInPostListAll.addAll(responseEntity.getBody().getPointsList());
            }
            List<DeliveryPoint> deliveryPointList = this.pointInPostMapper.pointInPostListToDeliveryPointBasicList(pointInPostListAll);
            fillDataUnavailableInInPostApi(deliveryPointList);
            filterDataUnavailableInInPostApi(deliveryPointList, searchCriteria);
            return deliveryPointList;
        } catch (RestClientException e) {
            log.error("Error when getting list of InPost Delivery places", e);
            throw new SearchingInPostDeliveryException();
        }
    }

    private void fillDataUnavailableInInPostApi(List<DeliveryPoint> deliveryPointList) {
        List<String> inPostIDs = deliveryPointList.stream()
                .map(DeliveryPoint::getName)
                .collect(Collectors.toList());
        if (!inPostIDs.isEmpty()) {
            try {
                List<DeliveryPointData> deliveryPointDataList = this.deliveryPointDataRepository.findByInPostIDs(inPostIDs);
                Map<String, DeliveryPointData> deliveryPointDataMap = new HashMap<>();
                for (DeliveryPointData deliveryPointData : deliveryPointDataList) {
                    deliveryPointDataMap.put(deliveryPointData.getInpostId(), deliveryPointData);
                }
                for (DeliveryPoint deliveryPoint : deliveryPointList) {
                    deliveryPoint.setDisabledFriendly(deliveryPointDataMap.get(deliveryPoint.getName()).isDisabledFriendly());
                    deliveryPoint.setOccupancy(deliveryPointDataMap.get(deliveryPoint.getName()).getOccupancy());
                    deliveryPoint.setParking(deliveryPointDataMap.get(deliveryPoint.getName()).isParking());
                    deliveryPoint.setWeekendPickup(deliveryPointDataMap.get(deliveryPoint.getName()).isWeekendPickup());
                    deliveryPoint.setTimeToPickup(deliveryPointDataMap.get(deliveryPoint.getName()).getTimeToPickup());
                }
            } catch (Exception ex) {
                log.error("Error when getting DeliveryPointData from database");
                throw ex;
            }
        }

    }

    private void filterDataUnavailableInInPostApi(List<DeliveryPoint> deliveryPointList, SearchDeliveryPointDTO searchCriteria) {
        Iterator<DeliveryPoint> deliveryPointIterator = deliveryPointList.iterator();
        if (searchCriteria.getParking() != null) {
            while (deliveryPointIterator.hasNext()) {
                DeliveryPoint deliveryPoint = deliveryPointIterator.next();
                if (!searchCriteria.getParking().equals(deliveryPoint.isParking())) {
                    deliveryPointIterator.remove();
                }
            }
        }
        deliveryPointIterator = deliveryPointList.iterator();
        if (searchCriteria.getDisabledFriendly() != null) {
            while (deliveryPointIterator.hasNext()) {
                DeliveryPoint deliveryPoint = deliveryPointIterator.next();
                if (!searchCriteria.getDisabledFriendly().equals(deliveryPoint.isDisabledFriendly())) {
                    deliveryPointIterator.remove();
                }
            }
        }
        deliveryPointIterator = deliveryPointList.iterator();
        if (searchCriteria.getWeekendPickup() != null) {
            while (deliveryPointIterator.hasNext()) {
                DeliveryPoint deliveryPoint = deliveryPointIterator.next();
                if (!searchCriteria.getWeekendPickup().equals(deliveryPoint.isWeekendPickup())) {
                    deliveryPointIterator.remove();
                }
            }
        }
    }

    private Map<String, String> parseSearchCriteria(SearchDeliveryPointDTO searchCriteria) {
        Map<String, String> params = new HashMap<>();
        if (searchCriteria.getMaxDistance() != null) {
            params.put("max_distance", searchCriteria.getMaxDistance().toString());
        } else {
            params.put("max_distance", DEFAULT_MAX_DISTANCE);
        }
        return params;
    }

    private void validateLocation(Location location) {
        if (location == null
                || location.getLongitude() == null
                || location.getLatitude() == null) {
            throw new IllegalArgumentException("Niepoprawne dane location");
        }
    }
}