package pl.allegro.braincode.team10.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.allegro.braincode.team10.google.dtoGoogle.Coordinates;
import pl.allegro.braincode.team10.inPost.model.Location;

@Mapper(componentModel = "spring")
public interface CoordinatesMapper {

    @Mapping(source = "latitude", target = "latitude")
    @Mapping(source = "longitude", target = "longitude")
    Location coordinatesToLocation(Coordinates coordinates);
}
