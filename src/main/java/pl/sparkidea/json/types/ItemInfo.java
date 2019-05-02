package pl.sparkidea.json.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemInfo implements Details {

    @JsonProperty("item")
    private final String item;
    @JsonProperty("id")
    private final String id;
    @JsonProperty("order")
    private final Long orderNumber;

    @JsonCreator
    public ItemInfo(
            @JsonProperty("item") String item,
            @JsonProperty("id") String id,
            @JsonProperty("order") Long orderNumber) {
        this.item = item;
        this.id = id;
        this.orderNumber = orderNumber;
    }

    public String getItem() {
        return item;
    }

    public String getId() {
        return id;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }
}
