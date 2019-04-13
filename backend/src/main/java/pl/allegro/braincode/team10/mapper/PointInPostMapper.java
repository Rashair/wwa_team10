package pl.allegro.braincode.team10.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.allegro.braincode.team10.dto.DeliveryPointBasic;
import pl.allegro.braincode.team10.inPost.dtoInPost.PointInPost;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PointInPostMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "location.latitude", target = "latitude")
    @Mapping(source = "location.longitude", target = "longitude")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "openingHours", target = "openingHours")
    DeliveryPointBasic pointInPostToDeliveryPointBasic(PointInPost pointInPost);

    List<DeliveryPointBasic> pointInPostListToDeliveryPointBasicList(List<PointInPost> pointInPostList);
}
