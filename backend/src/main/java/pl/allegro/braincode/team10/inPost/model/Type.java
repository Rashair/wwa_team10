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
        namesMap.put("parcel_locker", PARCEL_LOCKER);
        namesMap.put("pop", POP);
        namesMap.put("parcel_locker_only", PARCEL_LOCKER_ONLY);
        namesMap.put("parcel_locker_superpop", PARCEL_LOCKER_SUPERPOP);
        namesMap.put("unknownType", UNKNOWN_TYPE);
    }

    @JsonValue
    public String toValue() {
        for (Map.Entry<String, Type> entry : namesMap.entrySet()) {
            if (entry.getValue() == this)
                return entry.getKey();
        }

        return null;
    }

    @JsonCreator
    public static Type fromValue(String value) {
        System.out.println(value);
        return namesMap.get(value);
    }
}
