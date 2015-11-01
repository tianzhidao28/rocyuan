package com.jueyue.onepiece.test.request;

import cn.afterturn.http.annotation.IRequest;
import cn.afterturn.http.annotation.IRequestMethod;
import cn.afterturn.http.annotation.IRequestParam;
import cn.afterturn.http.entity.enums.RequestTypeEnum;

import com.jueyue.onepiece.test.entity.BaiduWeatherEntity;

/**
 * 测试接口
 * 
 * @author JueYue 2014年5月17日 - 上午10:23:32
 */
@IRequest("copytestRequest")
public interface CopyOfITestRequest {

    @IRequestMethod(type = RequestTypeEnum.GET, url = "http://api.map.baidu.com/telematics/v3/weather")
    String testGet(@IRequestParam("location") String location,
                   @IRequestParam("output") String output, @IRequestParam("ak") String ak);

    @IRequestMethod(type = RequestTypeEnum.GET, url = "http://api.map.baidu.com/telematics/v3/weather")
    BaiduWeatherEntity testGetEntity(@IRequestParam("location") String location,
                                     @IRequestParam("output") String output,
                                     @IRequestParam("ak") String ak);

}
