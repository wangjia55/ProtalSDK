package com.cvte.protal.sdk.tools;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Package : com.cvte.protal.sdk.tools
 * Author : jacob
 * Date : 14-12-2
 * Description : 这个类是用来管理Token的工具类
 */
public class TokenManager {
    private static final String TOKEN = "sdk_token";
    private static final String ACCESS_TOKEN = "sdk_access_token";
    private static final String REFRESH_TOKEN = "sdk_refresh_token";
    private static final String EXPIRE_IN = "sdk_expire_in";

    /**
     * 用来判断是token是否存在
     */
    public static boolean checkIsTokenAvailable(Context context) {
        return getAccessToken(context) == null;
    }

    /**
     * 将token缓存在本地
     */
    public static boolean savedAccessToken(Context context, String accessToken) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(TOKEN, Context.MODE_PRIVATE);
        return sharedPreferences.edit().putString(ACCESS_TOKEN, accessToken).commit();
    }

    /**
     * 获取缓存的token
     */
    public static String getAccessToken(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(TOKEN, Context.MODE_PRIVATE);
        return sharedPreferences.getString(ACCESS_TOKEN, null);
    }

    /**
     * 将refreshToken缓存在本地
     */
    public static boolean savedRefreshToken(Context context, String refreshToken) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(TOKEN, Context.MODE_PRIVATE);
        return sharedPreferences.edit().putString(REFRESH_TOKEN, refreshToken).commit();
    }

    /**
     * 将ExpireIn缓存在本地
     */
    public static boolean savedExpireIn(Context context, long expireIn) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(TOKEN, Context.MODE_PRIVATE);
        return sharedPreferences.edit().putLong(EXPIRE_IN, expireIn).commit();
    }

    /**
     * 获取ExpireIn
     */
    public static long getExpireIn(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(TOKEN, Context.MODE_PRIVATE);
        return sharedPreferences.getLong(EXPIRE_IN, -1);
    }

    /**
     * 获取RefreshToken
     */
    public static String getRefreshToken(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(TOKEN, Context.MODE_PRIVATE);
        return sharedPreferences.getString(REFRESH_TOKEN, null);
    }
}

