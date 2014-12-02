package com.cvte.protal.sdk.data;

/**
 * Package : com.cvte.protal.sdk.data
 * Author : jacob
 * Date : 14-12-1
 * Description : 这个类是用来xxx
 */
public class ProtalResponse {
    /**
     * 服务器返回的操作码
     */
    private int code;

    /**
     * 请求服务器的URL
     */
    private String url;

    /**
     * 服务器返回的异常信息
     */
    private String message;

    public int getCode() {
        return code;
    }

    public String getUrl() {
        return url;
    }

    public String getMessage() {
        return message;
    }
}
