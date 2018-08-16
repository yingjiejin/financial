package com.jyj.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonUtil {

    private static Logger log = LoggerFactory.getLogger(JsonUtil.class);

    private static ObjectMapper mapper = new ObjectMapper();

    public static String toJson(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            log.error("to json exception", e);
            throw new JSONException("把对象转换成JSON时出错", e);
        }
    }

    static final class JSONException extends RuntimeException {
        public JSONException(final String message, Exception e) {
            super(message, e);
        }
    }
}
