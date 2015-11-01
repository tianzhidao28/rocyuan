package cn.afterturn.http.util;

import java.util.List;

/**
 * JSON 解析接口
 * @author JueYue
 */
public interface IJsonServer {
    /**
     * 反解析单个类
     * @param json string
     * @param clss class type
     * @param <T> class type
     * @return T entity
     */
    public <T> T parseJson(String json, Class<?> clss);

    /**
     * 反解析List
     * @param json json str
     * @param clss class
     * @param <T>  类型
     * @return T
     */
    public <T> List<T> parseJsonList(String json, Class<?> clss);

    /**
     * toJson
     * @param obj object
     * @return string
     */
    public String toJson(Object obj);

}
