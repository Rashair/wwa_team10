package pl.allegro.braincode.team10.inPost.service.query.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.allegro.braincode.team10.dto.DeliveryPoint;
import pl.allegro.braincode.team10.dto.ListDTO;
import pl.allegro.braincode.team10.dto.SearchDeliveryPointDTO;
import pl.allegro.braincode.team10.exception.SearchingInPostDeliveryException;
import pl.allegro.braincode.team10.inPost.dtoInPost.PointInPost;
import pl.allegro.braincode.team10.inPost.dtoInPost.PointsList;
import pl.allegro.braincode.team10.inPost.model.Location;
import pl.allegro.braincode.team10.inPost.service.query.InPostQueryService;
import pl.allegro.braincode.team10.mapper.PointInPostMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class InPostQueryServiceImpl implements InPostQueryService {

    private PointInPostMapper pointInPostMapper;

    private final static String ENDPOINT_GET_POINTS = "https://api-shipx-pl.easypack24.net/v1/points";

    private final static String DEFAULT_MAX_DISTANCE = "2000";

    public InPostQueryServiceImpl(PointInPostMapper pointInPostMapper) {
        this.pointInPostMapper = pointInPostMapper;
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
            ListDTO<DeliveryPoint> listDTO = new ListDTO<>();
            List<DeliveryPoint> deliveryPointList = this.pointInPostMapper.pointInPostListToDeliveryPointBasicList(pointInPostListAll);
            return deliveryPointList;
        } catch (RestClientException e) {
            log.error("Error when getting list of InPost Delivery places", e);
            throw new SearchingInPostDeliveryException();
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