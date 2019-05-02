package pl.sparkidea.json.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes(@JsonSubTypes.Type(value = ListResponse.class, name = "listresponse"))
public class ListResponse<T extends Details> {

    @JsonProperty("status")
    private final String status;
    @JsonProperty("details")
    private final List<T> details;

    @JsonCreator
    public ListResponse(
            @JsonProperty("status") String status,
            @JsonProperty("details") List<T> details) {
        this.status = status;
        this.details = details;
    }

    public String getStatus() {
        return status;
    }

    public List<T> getDetails() {
        return details;
    }
}
