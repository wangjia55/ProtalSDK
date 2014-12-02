package com.cvte.protal.sdk.data;

/**
 * Package : com.cvte.protal.sdk.data
 * Author : jacob
 * Date : 14-12-1
 * Description : 这个类是用来xxx
 */
public interface CloudData<T> {
    public Class<T> getClassType();

    public void setId(String id);
}
