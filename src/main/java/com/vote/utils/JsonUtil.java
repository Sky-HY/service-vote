package com.vote.utils;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * json转换工具类
 */
public class JsonUtil {

    public static String pojoToJson(Object obj) {
        return JSON.toJSONString(obj);
    }

    public static <T> T jsonToPojo(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

    public static String listToJson(List list) {
        return JSON.toJSONString(list);
    }

    public static <T> List<T> jsonToList(String json, Class<T> clazz) {
        return JSON.parseArray(json, clazz);
    }
}
