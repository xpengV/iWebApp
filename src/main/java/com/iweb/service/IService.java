package com.iweb.service;

import com.iweb.service.type.Request;
import com.iweb.service.type.Response;

/**
 * -------------------------------------------------
 *
 * @InterfaceName IService
 * @Auther xiaopeng
 * @Date 2019/2/18 14:11
 * @Version 1.0
 * @Description TODO
 * -------------------------------------------------
 */
public interface IService {

    Class<? extends Request> getRequestModel();
    Class<? extends Response> getResponseModel();
    String doService(String reqJson);
}
