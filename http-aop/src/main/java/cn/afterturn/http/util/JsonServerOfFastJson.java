package cn.afterturn.http.util;

import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * json 工具类 json版本
 * @author JueYue
 */
@SuppressWarnings("unchecked")
public class JsonServerOfFastJson implements IJsonServer {

    public <T> T parseJson(String json, Class<?> clazz) {
        return (T) JSON.parseObject(json, clazz);
    }

    public <T> List<T> parseJsonList(String json, Class<?> clazz) {
        return (List<T>) JSON.parseArray(json, clazz);
    }

    public String toJson(Object obj) {
        return JSON.toJSONString(obj);
    }

}
