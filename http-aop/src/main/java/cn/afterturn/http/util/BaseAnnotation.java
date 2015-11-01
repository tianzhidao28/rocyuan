package cn.afterturn.http.util;

import cn.afterturn.http.annotation.IRequestMethod;

/**
 * 获取默认注解,减少注解的写入
 * @author JueYue
 */
public class BaseAnnotation {

    @IRequestMethod(connectTimeout = 60)
    public void requestMethod() {
        throw new UnsupportedOperationException();
    }

}
