package pl.allegro.braincode.team10.dto;

import lombok.Data;

import java.util.List;

/**
 * Object wrapper for lists for security reasons
 *
 * @param <T> Type of objects sotred in list
 */
@Data
public class ListDTO<T> {
    private List<T> values;
}
