package com.github.itwild.less.base.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Map;

@Slf4j
public abstract class JsonUtil {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * encode
     */
    public static String encode(Object value) throws IOException {
        return MAPPER.writeValueAsString(value);
    }

    public static String prettyEncode(Object value) throws IOException {
        return MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(value);
    }

    public static String safeEncode(Object value) {
        try {
            return MAPPER.writeValueAsString(value);
        } catch (IOException e) {
            log.error("json safe encode error", e);
            return null;
        }
    }

    public static String safePrettyEncode(Object value) {
        try {
            return MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(value);
        } catch (IOException e) {
            log.error("json safe pretty encode error", e);
            return null;
        }
    }

    /**
     * decode
     */
    public static <T> T decode(String content, Class<T> valueType) throws IOException {
        return MAPPER.readValue(content, valueType);
    }

    public static <T> T decode(String content, TypeReference<T> valueTypeRef) throws IOException {
        return MAPPER.readValue(content, valueTypeRef);
    }

    public static <T> T decode(InputStream src, Class<T> valueType) throws IOException {
        return MAPPER.readValue(src, valueType);
    }

    public static <T> T decode(InputStream src, TypeReference<T> valueTypeRef) throws IOException {
        return MAPPER.readValue(src, valueTypeRef);
    }

    public static <T> T safeDecode(String content, Class<T> valueType) {
        try {
            return MAPPER.readValue(content, valueType);
        } catch (IOException e) {
            log.error("json decode error", e);
            return null;
        }
    }

    public static <T> T safeDecode(String content, TypeReference<T> valueTypeRef) {
        try {
            return MAPPER.readValue(content, valueTypeRef);
        } catch (IOException e) {
            log.error("json decode error", e);
            return null;
        }
    }

    /**
     * @param type 反射的时候获取到的类型
     */
    public static <T> T decode(String content, Type type) throws IOException {
        return MAPPER.readValue(content, TypeFactory.defaultInstance().constructType(type));
    }

    public static JsonNode decode2Tree(String content) throws IOException {
        return MAPPER.readTree(content);
    }

    public static Map<String, Object> decode2Map(String content) throws IOException {
        return decode(content, new TypeReference<Map<String, Object>>() {
        });
    }

    public static Map<String, Object> decode2Map(InputStream src) throws IOException {
        return decode(src, new TypeReference<Map<String, Object>>() {
        });
    }

    public static Map<String, Object> bean2Map(Object value) throws IOException {
        return decode2Map(encode(value));
    }

    public static <T> T map2Bean(Map value, Class<T> valueType) throws IOException {
        return MAPPER.readValue(encode(value), valueType);
    }
}
