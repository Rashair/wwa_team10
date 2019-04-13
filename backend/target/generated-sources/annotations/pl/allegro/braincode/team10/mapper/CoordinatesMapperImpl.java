package pl.allegro.braincode.team10.mapper;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import pl.allegro.braincode.team10.google.dtoGoogle.Coordinates;
import pl.allegro.braincode.team10.inPost.model.Location;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-04-13T07:30:29+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class CoordinatesMapperImpl implements CoordinatesMapper {

    @Override
    public Location coordinatesToLocation(Coordinates coordinates) {
        if ( coordinates == null ) {
            return null;
        }

        Location location = new Location();

        location.setLatitude( coordinates.getLatitude() );
        location.setLongitude( coordinates.getLongitude() );

        return location;
    }
}
