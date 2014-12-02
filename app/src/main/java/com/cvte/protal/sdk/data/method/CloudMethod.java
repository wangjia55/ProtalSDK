package com.cvte.protal.sdk.data.method;

import com.cvte.protal.sdk.data.listener.ProtalResponseListener;

import org.json.JSONObject;

import java.util.Map;

/**
 * Package : com.cvte.protal.sdk.data.method
 * Author : jacob
 * Date : 14-12-1
 * Description : 这个类是用来xxx
 */
public interface CloudMethod {
    /**
     * 通过Volley执行网络请求操作
     */
    public void execute(ProtalResponseListener listener);

    /**
     * 添加网络请求的Header
     */
    public CloudMethod addHeader(Map<String, String> headers);

    /**
     * 添加网络请求的Body部分
     */
    public CloudMethod addBody(JSONObject body);


    /**
     * 多表关联之间的关系
     */
    public enum Relation {
        ONE_TO_ONE("[1:1]"), ONE_TO_MANY("[1:n]"), MANY_TO_ONE("[m:1]"), MANY_TO_MANY("[m:n]");

        private String mValue;

        private Relation(String value) {
            mValue = value;
        }

        public String value() {
            return mValue;
        }
    }
}
