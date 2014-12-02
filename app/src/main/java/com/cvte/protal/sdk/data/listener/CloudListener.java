package com.cvte.protal.sdk.data.listener;

import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * Package : com.cvte.protal.sdk.data.listener
 * Author : jacob
 * Date : 14-12-1
 * Description : 这个类是用来xxx
 */
public abstract class CloudListener<T extends Object> implements Response.Listener<T>, Response.ErrorListener {
    @Override
    public void onErrorResponse(VolleyError volleyError) {

    }

    @Override
    public void onResponse(T t) {

    }
}
