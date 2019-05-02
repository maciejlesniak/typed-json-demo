package pl.sparkidea.json.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class InfoDetails implements Details {

    @JsonProperty("name")
    private final String name;
    @JsonProperty("id")
    private final String id;

    @JsonCreator
    public InfoDetails(@JsonProperty("name") String name, @JsonProperty("id") String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
