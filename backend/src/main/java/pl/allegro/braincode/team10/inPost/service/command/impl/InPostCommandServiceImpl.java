package pl.allegro.braincode.team10.inPost.service.command.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.allegro.braincode.team10.dto.DeliveryPointBasic;
import pl.allegro.braincode.team10.dto.ListDTO;
import pl.allegro.braincode.team10.inPost.dtoInPost.PointInPost;
import pl.allegro.braincode.team10.inPost.dtoInPost.PointsList;
import pl.allegro.braincode.team10.inPost.service.command.InPostCommandService;
import pl.allegro.braincode.team10.mapper.PointInPostMapper;

import java.util.List;

@Service
public class InPostCommandServiceImpl implements InPostCommandService {

    private PointInPostMapper pointInPostMapper;

    public InPostCommandServiceImpl(PointInPostMapper pointInPostMapper) {
        this.pointInPostMapper = pointInPostMapper;
    }

    public ListDTO<DeliveryPointBasic> test() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PointsList> responseEntity = restTemplate.getForEntity("https://api-shipx-pl.easypack24.net/v1/points", PointsList.class);
        PointsList pointsList = responseEntity.getBody();
        List<PointInPost> pointInPosts = pointsList.getPointsList();
        ListDTO<DeliveryPointBasic> listDTO = new ListDTO<>();
        List<DeliveryPointBasic> basic = this.pointInPostMapper.pointInPostListToDeliveryPointBasicList(pointInPosts);
        listDTO.setValues(basic);
        return listDTO;
    }
}
