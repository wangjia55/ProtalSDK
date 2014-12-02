package com.cvte.protal.sdk.data.auth;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Package : com.cvte.protal.sdk.tools
 * Author : jacob
 * Date : 14-12-2
 * Description : 这个类是用来控制和管理所有和帐号相关的所有操作
 */
public class AuthenticationManager {


    private static final String ACTION = "action";
    private static final String PASSWORD = "password";

    /**
     * 获取请求Header，只需要传入控制参数即可
     */
    public static HashMap<String, String> getRequestHeader(AuthEnum authEnum) {
        return getRequestHeader(ACTION, authEnum.getAction());
    }


    /**
     * 得到请求的header，主要用于登录接口，登录接口所有的请求都是：protal/cloud/vx/accounts.json?
     * 只是Action不一样
     */
    private static HashMap<String, String> getRequestHeader(String key, String value) {
        HashMap<String, String> header = new HashMap<String, String>();
        header.put(key, value);
        return header;
    }


    /**
     * 获取帐号验证相关的Body
     */
    public static JSONObject getRequestBody(String account, String password, String appKey, String appSecret) {
        Authentication authentication = new Authentication.Builder()
                .setAccount(account)
                .setPassword(password)
                .setAppKey(appKey)
                .setAppSecret(appSecret)
                .setGrantType(PASSWORD)
                .build();
        try {
            return getJsonObject(authentication);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new JSONObject();
    }


    /**
     * 将Authentication对象转成Json对象，因为在请求过程中Body一般是json数据
     */
    private static JSONObject getJsonObject(Authentication authentication) throws JSONException {
        Gson gson = new Gson();
        return new JSONObject(gson.toJson(authentication));
    }


    /**
     * 和帐号相关的所有请求控制参数都在这里
     */
    public enum AuthEnum {
        LOGIN("login"),
        REGISTER("register"),
        RESET_PASSWORD("resetpassword"),
        LOGOUT("logout"),
        VALIDATE("validate"),
        AUTH_CODE("authcode"),
        CHANGE_ACCOUNT("changeaccount");

        String action;

        AuthEnum(String action) {
            this.action = action;
        }

        public String getAction() {
            return action;
        }
    }

}
