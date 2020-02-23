package com.daling.platform.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class Jackson2Helper {

    private static Logger log = LoggerFactory.getLogger(Jackson2Helper.class);

    private static final ObjectMapper mapper = new ObjectMapper();

    public static final String toJsonString(Object obj) {
        try {
            // Writer strWriter = new StringWriter();
            // mapper.writeValue(strWriter, obj);
            // return strWriter.toString();
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            log.error("error",e);
        }
        return null;
    }

    public static final <T> T parsingObject(String jsonString, Class<T> cls) throws Exception {
        try {

            // 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(jsonString, cls);
        } catch (JsonParseException e) {
            throw new Exception(e);
        } catch (JsonMappingException e) {
            throw new Exception(e);
        } catch (IOException e) {
            throw new Exception(e);
        }
    }

    public static final JsonNode parsingObject(String jsonString) throws Exception {
        if (StringUtils.isBlank(jsonString)) {
            return null;
        }
        try {
            // 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readTree(jsonString);
        } catch (JsonParseException e) {
            throw new Exception(e);
        } catch (JsonMappingException e) {
            throw new Exception(e);
        } catch (IOException e) {
            throw new Exception(e);
        }
    }

    /**
     * 支持泛型
     *
     * <li>TypeReference<Result<List<OrderDto>>> typeRef = new TypeReference<Result<List<OrderDto>>>() { };</li>
     *
     * <li>Result<List<OrderDto>> result = mapper.readValue(content, typeRef);</li>
     *
     * @author yj
     * @param jsonString
     * @param valueTypeRef
     * @return <T> T
     */
    public static final <T> T parsingObject(String jsonString, TypeReference<T> valueTypeRef) {
        if (StringUtils.isBlank(jsonString)) {
            return null;
        }
        try {
            // 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(jsonString, valueTypeRef);
        } catch (IOException e) {
            log.error("error",e);
        }
        return null;
    }

    public static <T extends Object> List<T> jsonToList(String json, Class<T> bean){
        if (StringUtils.isBlank(json)) {
            return null;
        }
        try {
            JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, bean);
            return mapper.readValue(json, javaType);
        } catch (IOException e) {
            log.error("error",e);
        }
        return null;
    }

    public static JsonNode readJson(String json){
        try {
            return mapper.readTree(json);
        } catch (Exception e) {
            log.error("readJson error ", e);
        }
        return null;
    }
}
