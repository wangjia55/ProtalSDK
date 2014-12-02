package com.cvte.protal.sdk.data.method;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.cvte.protal.sdk.data.CloudVolley;
import com.cvte.protal.sdk.data.listener.ProtalResponseListener;

import org.json.JSONObject;

import java.util.Map;

/**
 * Package : com.cvte.protal.sdk.data.method
 * Author : jacob
 * Date : 14-12-1
 * Description : 这个类是用来xxx
 */
public abstract class BaseProtalMethodImpl implements CloudMethod {

    private String mServerIp;
    private String mAppKey;
    private String mAccessToken;
    private JSONObject mRequestBody;
    private Map<String, String> mHeaders;
    private ProtalResponseListener mProtalListener;
    private static final String ACCESS_TOKEN = "accessToken";
    private static final String APPLICATION = "application";

    protected Relation mRelation;
    protected static final String SERVER_URL = "";
    protected StringBuilder mSBurl = new StringBuilder(SERVER_URL);


    public BaseProtalMethodImpl(String severIp, String appKey,String accessToken) {
        mServerIp = severIp;
        mAppKey = appKey;
        mAccessToken = accessToken;
    }


    /**
     * 添加请求的头信息，请注意：不是所有的请求都需要header信息
     */
    @Override
    public BaseProtalMethodImpl addHeader(Map<String, String> headers) {
        mHeaders = headers;
        mHeaders.put(APPLICATION, mAppKey);
        mHeaders.put(ACCESS_TOKEN, mAccessToken);
        return this;
    }


    /**
     * 添加请求的body信息，请注意：不是所有的请求都需要body信息
     */
    @Override
    public BaseProtalMethodImpl addBody(JSONObject body) {
        mRequestBody = body;
        return this;
    }

    /**
     * 创建请求成功的Listener
     */
    private Response.Listener<String> createRequestSuccessListener() {
        return new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                mProtalListener.get(response);
            }
        };
    }


    /**
     * 创建请求失败的Listener
     */
    private Response.ErrorListener createMyReqErrorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mProtalListener.Exception(error);
            }
        };
    }


    /**
     * 核心方法：通过Volley的API进行网络请求
     */
    @Override
    public void execute(ProtalResponseListener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("listener can not be null");
        }
        mProtalListener = listener;
        RequestQueue queue = CloudVolley.getRequestQueue();
        StringRequest jsonRequest = new StringRequest(getRestMethod(),
                mSBurl.toString(),
                createRequestSuccessListener(),
                createMyReqErrorListener()) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return mHeaders;
            }
        };
        queue.add(jsonRequest);
    }

    /**
     * 获取Request的方法类型，通过子类实现该方法获取
     */
    protected abstract int getRestMethod();

    /**
     * 获取网络请求的路径URL
     */
    protected void addPath(String name, String id) {
        mSBurl.append(name).append("/").append(id);
    }

}
