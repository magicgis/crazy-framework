package org.beyondj2ee.crazyframework.ajax.controller;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.util.TokenBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonParser {
	
	private static final Logger logger = LoggerFactory
			.getLogger(JsonParser.class);
	
	/**
	 * <p>
	 * description about class
	 * </p>
	 * Marshalling json.
	 * 
	 * @param object the object
	 * @return the string
	 * @throws Exception the exception
	 */
	public static String marshallingJson(Object object) throws Exception {
		TokenBuffer buffer = new TokenBuffer(null);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(buffer, object);
		JsonNode root = objectMapper.readTree(buffer.asParser());
		String jsonText = objectMapper.writeValueAsString(root);
		return jsonText;
	}

	/**
	 * <p>
	 * description about class
	 * </p>
	 * Unmarshalling json.
	 * 
	 * @param <T> the
	 * @param jsonText the json text
	 * @param valueType the value type
	 * @return the t
	 * @throws Exception the exception
	 */
	public static <T> T unmarshallingJson(String jsonText, Class<T> valueType)
			throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		return (T) objectMapper.readValue(jsonText, valueType);
	}
}
