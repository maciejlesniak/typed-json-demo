package pl.sparkidea.json.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = InfoDetails.class, name = "info"),
        @JsonSubTypes.Type(value = FullDetails.class, name = "full"),
        @JsonSubTypes.Type(value = ItemInfo.class, name = "iteminfo")
})
public interface Details {
    // marker interface
}
