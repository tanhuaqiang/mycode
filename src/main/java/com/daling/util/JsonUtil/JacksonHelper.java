package com.daling.util.JsonUtil;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;

/**
 * @author : tanhq
 * @version :
 * @date : Created in 2020/3/14 上午8:53
 * @description:
 */
public class JacksonHelper {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static Logger log = Logger.getLogger(JacksonHelper.class);

    public static <T extends Object> List<T> jsonToList(String json, Class<T> bean){
        JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, bean);
        try {
            return mapper.readValue(json, javaType);
        } catch (IOException e) {
            log.error("jsonToList error ", e);
        }
        return null;
    }
}
