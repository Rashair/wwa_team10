package pl.allegro.braincode.team10.inPost.model;

import pl.allegro.braincode.team10.dto.DeliveryPoint;

import java.util.Random;

public class DeliveryPointDummy {
    public DeliveryPoint getDeliveryPoint(){
        DeliveryPoint deliveryPoint = new DeliveryPoint();
        Random generator = new Random();
        deliveryPoint.setOccupancy(generator.nextInt(21) * 5);
        deliveryPoint.setParking(generator.nextBoolean());
        deliveryPoint.setTimeToPickup(generator.nextInt(12) + 2);
        deliveryPoint.setWeekendPickup(generator.nextBoolean());
        deliveryPoint.setDisabledFriendly(generator.nextBoolean());

        return deliveryPoint;
    }
}
