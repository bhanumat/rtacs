package com.itos.util;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;

/**
 * The Class JSONUtil.
 *
 * @author Bhanumat W.
 */
public class JsonUtil {

    /**
     * Instantiates a new JSON util.
     */
    private JsonUtil() {

    }

    /**
     * Convert Object to JSON string.
     *
     * @param object the object
     * @return the string
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonGenerationException
     */
    public static String toJsonString(Object object)
            throws JsonGenerationException, JsonMappingException, IOException {

        return JSONParser.OBJECT_MAPPER.writeValueAsString(object);
    }

    /**
     * Convert jsonText to JsonNode.
     *
     * @param jsonText the JSON text
     * @return the JSON node
     * @throws JsonProcessingException the JSON processing exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static JsonNode toJsonNode(String jsonText)
            throws JsonProcessingException, IOException {

        return JSONParser.OBJECT_MAPPER.readTree(jsonText);
    }

    /**
     * Convert JSON string to {@code Map<String, Object>}
     *
     * @param jsonText the JSON text
     * @return the map
     * @throws JsonParseException the JSON parse exception
     * @throws JsonMappingException the JSON mapping exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static Map<String, Object> toMap(String jsonText)
            throws JsonParseException, JsonMappingException, IOException {

        // convert JSON string to Map
        Map<String, Object> map = JSONParser.OBJECT_MAPPER.readValue(jsonText, new TypeReference<Map<String, Object>>() {
        });

        return map;
    }

    /**
     * Parse jsonText string to Object @code {< T >}
     *
     * @param <T>
     * @param jsonText
     * @param clazz
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    public static <T> T parse(String jsonText, Class<T> clazz)
            throws JsonParseException, JsonMappingException, IOException {

        JSONParser<T> parser = new JSONParser<>(clazz);
        return parser.parse(jsonText);
    }

    static public class JSONParser<T> {

        public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

        private final Class<? extends T> type;

        public JSONParser(Class<? extends T> type) {

            this.type = type;
        }

        /**
         * Parses the jsonText.
         *
         * @param jsonText the JSON text
         * @return the {@code T}
         * @throws IOException
         * @throws JsonMappingException
         * @throws JsonParseException
         */
        public T parse(String jsonText)
                throws JsonParseException, JsonMappingException, IOException {

            return OBJECT_MAPPER.readValue(jsonText, type);
        }
    }
//
//	public static void main(String[] args)
//		throws JsonProcessingException, IOException {
//
//		JsonNode node = JSONParser.OBJECT_MAPPER.readTree("{\"name\":\"888159CF-45BE-475F-8C6A-64B3E1D97278.jpg\"}");
//		System.out.println(node.get("name"));
//	}

}
