package com.book.management.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 2019/4/2.
 */
public class JsonUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

//    static {
//        objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
//        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
//        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
//        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
//        objectMapper.configure(JsonParser.Feature.INTERN_FIELD_NAMES, true);
//        objectMapper.configure(JsonParser.Feature.CANONICALIZE_FIELD_NAMES, true);
//        objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//    }

    public static String toJson(Object object) {
        try {
            if (object != null) {
                return objectMapper.writeValueAsString(object);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static <T> T fromJson(String json, Class<T> valueType) {
        try {
            if (json != null) {
                return objectMapper.readValue(json, valueType);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //new TypeReference<List<ClassifyBean>>() {}
    //    Map<String, Object> map2 = mapper.readValue(text, new TypeReference<Map<String, Object>>() {});
    public static <T> T fromJson(String json, TypeReference<T> typeReference) {
        try {
            if (json != null) {
                return objectMapper.readValue(json, typeReference);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> List<T> toList(String json) {
        try {
            if (json != null) {
                TypeReference<ArrayList<T>> tr = new TypeReference<ArrayList<T>>() {
                };
                return objectMapper.readValue(json, tr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
