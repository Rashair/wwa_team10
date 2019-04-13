package pl.allegro.braincode.team10.inPost.dtoInPost;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PointsList {
    @JsonProperty("items")
    List<PointInPost> pointsList;

    @JsonProperty("total_pages")
    Integer totalPages;
}
