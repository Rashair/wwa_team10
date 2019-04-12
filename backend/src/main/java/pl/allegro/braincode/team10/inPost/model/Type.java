package pl.allegro.braincode.team10.inPost.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Type {
    PARCEL_LOCKER("parcel_locker"),
    POP("pop"),
    PARCEL_LOCKER_ONLY("parcel_locker_only"),
    PARCEL_LOCKER_SUPERPOP("parcel_locker_superpop");

    private String description;
}
