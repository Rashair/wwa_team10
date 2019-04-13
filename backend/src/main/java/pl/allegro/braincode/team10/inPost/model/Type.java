package pl.allegro.braincode.team10.inPost.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public enum Type {
    PARCEL_LOCKER("parcel_locker"),
    POP("pop"),
    PARCEL_LOCKER_ONLY("parcel_locker_only"),
    PARCEL_LOCKER_SUPERPOP("parcel_locker_superpop"),
    UNKNOWN_TYPE("unknownType");
    private String description;

    private static Map<String, Type> namesMap = new HashMap<>();

    static {
        namesMap.put(PARCEL_LOCKER.description, PARCEL_LOCKER);
        namesMap.put(POP.description, POP);
        namesMap.put(PARCEL_LOCKER_ONLY.description, PARCEL_LOCKER_ONLY);
        namesMap.put(PARCEL_LOCKER_SUPERPOP.description, PARCEL_LOCKER_SUPERPOP);
        namesMap.put(UNKNOWN_TYPE.description, UNKNOWN_TYPE);
    }

    @JsonValue
    public String toValue() {
        return this.description;
    }

    @JsonCreator
    public static Type fromValue(String value) {
        return namesMap.get(value);
    }
}
