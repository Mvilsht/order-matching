package compelete;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JacksonMapper {

     private final static ObjectMapper MAPPER = new ObjectMapper();

     static {
         MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
     }

//    public String writeValueAsString(Object value) throws JsonProcessingException {
//         return MAPPER.writeValueAsString(value);
//    }

    public static JsonNode readTree(File file)throws IOException, JsonProcessingException{
         return MAPPER.readTree(file);
    }

    public static <T> T readValue(String content, Class<T> valueType) throws IOException{
        return MAPPER.readValue(content, valueType);
    }

    public static <T> T readValue(File content, Class<T> valueType) throws IOException {
        return MAPPER.readValue(content, valueType);
    }
}
