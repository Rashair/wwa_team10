package pl.allegro.braincode.team10.mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import pl.allegro.braincode.team10.dto.DeliveryPointBasic;
import pl.allegro.braincode.team10.inPost.dtoInPost.PointInPost;
import pl.allegro.braincode.team10.inPost.model.Address;
import pl.allegro.braincode.team10.inPost.model.Location;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-04-13T06:22:36+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class PointInPostMapperImpl implements PointInPostMapper {

    @Override
    public DeliveryPointBasic pointInPostToDeliveryPointBasic(PointInPost pointInPost) {
        if ( pointInPost == null ) {
            return null;
        }

        DeliveryPointBasic deliveryPointBasic = new DeliveryPointBasic();

        deliveryPointBasic.setName( pointInPost.getName() );
        deliveryPointBasic.setOpeningHours( pointInPost.getOpeningHours() );
        deliveryPointBasic.setAddress( addressToAddress( pointInPost.getAddress() ) );
        deliveryPointBasic.setLatitude( pointInPostLocationLatitude( pointInPost ) );
        deliveryPointBasic.setLongitude( pointInPostLocationLongitude( pointInPost ) );

        return deliveryPointBasic;
    }

    @Override
    public List<DeliveryPointBasic> pointInPostListToDeliveryPointBasicList(List<PointInPost> pointInPostList) {
        if ( pointInPostList == null ) {
            return null;
        }

        List<DeliveryPointBasic> list = new ArrayList<DeliveryPointBasic>( pointInPostList.size() );
        for ( PointInPost pointInPost : pointInPostList ) {
            list.add( pointInPostToDeliveryPointBasic( pointInPost ) );
        }

        return list;
    }

    protected pl.allegro.braincode.team10.dto.Address addressToAddress(Address address) {
        if ( address == null ) {
            return null;
        }

        pl.allegro.braincode.team10.dto.Address address1 = new pl.allegro.braincode.team10.dto.Address();

        address1.setCity( address.getCity() );
        address1.setProvince( address.getProvince() );
        address1.setPostCode( address.getPostCode() );
        address1.setStreet( address.getStreet() );
        address1.setBuildingNumber( address.getBuildingNumber() );
        address1.setFlatNumber( address.getFlatNumber() );

        return address1;
    }

    private BigDecimal pointInPostLocationLatitude(PointInPost pointInPost) {
        if ( pointInPost == null ) {
            return null;
        }
        Location location = pointInPost.getLocation();
        if ( location == null ) {
            return null;
        }
        BigDecimal latitude = location.getLatitude();
        if ( latitude == null ) {
            return null;
        }
        return latitude;
    }

    private BigDecimal pointInPostLocationLongitude(PointInPost pointInPost) {
        if ( pointInPost == null ) {
            return null;
        }
        Location location = pointInPost.getLocation();
        if ( location == null ) {
            return null;
        }
        BigDecimal longitude = location.getLongitude();
        if ( longitude == null ) {
            return null;
        }
        return longitude;
    }
}
