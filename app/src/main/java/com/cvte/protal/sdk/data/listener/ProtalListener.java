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

    public void get(List<T> list);

    public void get(String response);

    public void post(ProtalResponse response);

    public void delete(ProtalResponse response);

    public void patch(ProtalResponse response);

    public void Exception(Exception e);

}
