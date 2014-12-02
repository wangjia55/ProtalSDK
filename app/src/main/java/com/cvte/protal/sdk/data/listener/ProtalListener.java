package com.cvte.protal.sdk.data.listener;

import com.cvte.protal.sdk.data.CloudData;
import com.cvte.protal.sdk.data.ProtalResponse;

import java.util.List;

/**
 * Package : com.cvte.protal.sdk.data
 * Author : jacob
 * Date : 14-12-1
 * Description : 这个类是用来xxx
 */
public interface ProtalListener<T extends CloudData> {

    /**
     * 请求GET操作的回调函数
     */
    public void get(List<T> list);
    /**
     * 请求GET操作的回调函数
     */
    public void get(String response);
    /**
     * 请求POST操作的回调函数
     */
    public void post(ProtalResponse response);
    /**
     * 请求DELETE操作的回调函数
     */
    public void delete(ProtalResponse response);
    /**
     * 请求PATCH操作的回调函数
     */
    public void patch(ProtalResponse response);
    /**
     * 请求操作出现异常的回调函数
     */
    public void Exception(Exception e);

}
