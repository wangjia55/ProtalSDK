package com.cvte.protal.sdk.tools;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.cvte.protal.sdk.exception.MissingManifestConfigException;


/**
 * Package : com.cvte.protal.sdk.tools
 * Author : jacob
 * Date : 14-12-2
 * Description : 这个类是获取Manifest中配置参数的工具类
 */

public class ManifestMetadata {
    private static final String SERVER_ID = "cvte_server_ip";
    private static final String APP_KEY = "app_key";
    public static final String APP_SECRET = "app_secret";
    private static final String SERVER_IP = "http://121.199.53.253";

    private static Object readKey(Context context, String keyName) throws PackageManager.NameNotFoundException {
        ApplicationInfo appi = context.getPackageManager().getApplicationInfo(context.getPackageName(),
                PackageManager.GET_META_DATA);
        Bundle bundle = appi.metaData;
        Object value = bundle.get(keyName);
        return value;
    }


    private static String getString(Context context, String keyName) {
        try {
            return (String) readKey(context, keyName);
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        } catch (NullPointerException e) {
            return null;
        }
    }


    /**
     * 获取manifest中配置的服务器IP
     */
    public static String getServerIp(Context context) {
        String ip = getString(context, SERVER_ID);
        if (ip == null) {
            ip = SERVER_IP;
        }
        return ip;
    }

    /**
     * 获取manifest中配置的APPKEY
     */
    public static String getAppKey(Context context) {
        String appKey = getString(context, APP_KEY);
        if (appKey == null) {
            throw new MissingManifestConfigException("Request app_key in AndroidManifest.xml");
        }
        return appKey;
    }

    /**
     * 获取manifest中配置的APP_SECRET
     */
    public static String getAppSecret(Context context) {
        String appSecret = getString(context, APP_SECRET);
        if (appSecret == null) {
            throw new MissingManifestConfigException("Request app_secret in AndroidManifest.xml");
        }
        return appSecret;
    }

}