package com.cvte.protal.sdk.data.listener;

import com.cvte.protal.sdk.data.CloudData;
import com.cvte.protal.sdk.data.ProtalResponse;

import java.util.List;

/**
 * Package : com.cvte.protal.sdk.data.listener
 * Author : jacob
 * Date : 14-12-1
 * Description : 这个类是用来xxx
 */
public abstract class ProtalResponseListener<T extends CloudData> implements ProtalListener<T> {
    @Override
    public void get(List<T> list) {

    }

    @Override
    public void get(String response) {

    }

    @Override
    public void post(ProtalResponse response) {

    }

    @Override
    public void delete(ProtalResponse response) {

    }

    @Override
    public void patch(ProtalResponse response) {

    }

    @Override
    public void Exception(Exception e) {

    }
}
