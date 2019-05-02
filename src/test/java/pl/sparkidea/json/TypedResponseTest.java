package pl.sparkidea.json;

import org.junit.Test;
import pl.sparkidea.json.types.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TypedResponseTest {

    @Test
    public void getResponse_shouldConstructResponseWithInfo_whenInfoTypedJsonPassed() throws IOException {

        // given
        String json = readFile("info-response.json");

        // when
        Response<InfoDetails> response = TypedResponse.getResponse(json);

        // than
        assertThat(response.getStatus(), is("OK"));
        assertThat(response.getDetails().getId(), is("463zz02640"));
    }

    @Test
    public void getResponse_shouldConstructResponseWithFullDetails_whenInfoTypedJsonPassed() throws IOException {

        // given
        String json = readFile("full-response.json");

        // when
        Response<FullDetails> response = TypedResponse.getResponse(json);

        // than
        assertThat(response.getStatus(), is("OK"));
        assertThat(response.getDetails().getId(), is("ff463"));
    }

    @Test
    public void getListResponse_shouldConstructResponseWithListOfItemInfo_whenInfoTypedJsonPassed() throws IOException {

        // given
        String json = readFile("list-response.json");

        // when
        ListResponse<ItemInfo> response = TypedResponse.getListResponse(json);

        // than
        assertThat(response.getStatus(), is("OK"));
        assertThat(response.getDetails().get(0).getOrderNumber(), is(42L));
    }

    private String readFile(String resourceName) throws FileNotFoundException {
        File jsonFile = new File(ClassLoader.getSystemResource(resourceName).getPath());
        StringBuilder sb = new StringBuilder();
        if (jsonFile.canRead()) {
            Scanner scanner = new Scanner(jsonFile);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                sb.append(line.trim());
            }
        }

        return sb.toString();
    }
}