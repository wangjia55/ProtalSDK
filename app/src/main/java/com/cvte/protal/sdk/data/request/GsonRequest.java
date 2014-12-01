package com.cvte.protal.sdk.data.request;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;

/**
 * Package : com.cvte.protal.sdk.data.request
 * Author : jacob
 * Date : 14-12-1
 * Description : 这个类是用来xxx
 */
public class GsonRequest<T> extends Request<T> {
    public GsonRequest(String url, Response.ErrorListener listener) {
        super(url, listener);
    }

    public GsonRequest(int method, String url, Response.ErrorListener listener) {
        super(method, url, listener);
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse networkResponse) {
        return null;
    }

    @Override
    protected void deliverResponse(T t) {

    }
}
