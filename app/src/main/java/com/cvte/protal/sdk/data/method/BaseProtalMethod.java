package com.cvte.protal.sdk.data.method;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.cvte.protal.sdk.data.listener.ProtalResponseListener;

import org.json.JSONObject;

/**
 * Package : com.cvte.protal.sdk.data.method
 * Author : jacob
 * Date : 14-12-1
 * Description : 这个类是用来xxx
 */
public abstract class BaseProtalMethod implements CloudMethod {


    private ProtalResponseListener mProtalListener;

    @Override
    public void execute(ProtalResponseListener listener) {
        mProtalListener = listener;
        JsonObjectRequest jsonRequest = new JsonObjectRequest(getRestMethod(), "", null,
                createMyReqSuccessListener(),
                createMyReqErrorListener());
    }


    private Response.Listener<JSONObject> createMyReqSuccessListener() {
        return new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        };
    }


    private Response.ErrorListener createMyReqErrorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        };
    }

    /**
     * 获取Request的方法类型，通过子类实现该方法获取
     */
    protected abstract int getRestMethod();
}
