package pl.allegro.braincode.team10.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.allegro.braincode.team10.dto.DeliveryPoint;
import pl.allegro.braincode.team10.inPost.dtoInPost.PointInPost;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PointInPostMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "location.latitude", target = "latitude")
    @Mapping(source = "location.longitude", target = "longitude")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "openingHours", target = "openingHours")
    @Mapping(target = "distanceTextKm", ignore = true)
    @Mapping(target = "distanceValue", ignore = true)
    @Mapping(target = "occupancy", ignore = true)
    @Mapping(target = "parking", ignore = true)
    @Mapping(target = "weekendPickup", ignore = true)
    @Mapping(target = "timeToPickup", ignore = true)
    @Mapping(target = "disabledFriendly", ignore = true)
    DeliveryPoint pointInPostToDeliveryPointBasic(PointInPost pointInPost);

    List<DeliveryPoint> pointInPostListToDeliveryPointBasicList(List<PointInPost> pointInPostList);
}
