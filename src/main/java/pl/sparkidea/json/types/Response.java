package pl.sparkidea.json.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes(@JsonSubTypes.Type(value = Response.class, name = "response"))
public class Response<T extends Details> {

    @JsonProperty("status")
    private final String status;
    @JsonProperty("details")
    private final T details;

    @JsonCreator
    public Response(
            @JsonProperty("status") String status,
            @JsonProperty("details") T details) {
        this.status = status;
        this.details = details;
    }

    public String getStatus() {
        return status;
    }

    public T getDetails() {
        return details;
    }
}
