package pl.sparkidea.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sparkidea.json.types.Details;
import pl.sparkidea.json.types.ListResponse;
import pl.sparkidea.json.types.Response;

import java.io.IOException;

public class TypedResponse {

    @SuppressWarnings("unchecked")
    public static <T extends Details> Response<T> getResponse(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, Response.class);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Details> ListResponse<T> getListResponse(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, ListResponse.class);
    }

}
