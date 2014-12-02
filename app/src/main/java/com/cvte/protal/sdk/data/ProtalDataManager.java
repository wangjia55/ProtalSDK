package com.cvte.protal.sdk.data;


import android.content.Context;

import com.cvte.protal.sdk.data.post.Post;
import com.cvte.protal.sdk.data.post.PostMethod;
import com.cvte.protal.sdk.tools.ManifestMetadata;
import com.cvte.protal.sdk.tools.TokenManager;

/**
 * Package : com.cvte.protal.sdk.data
 * Author : jacob
 * Date : 14-12-1
 * Description : 这个类是用来统一调用GET，POST，PATCH，DELETE方法的对外功能入口
 */
public final class ProtalDataManager {

    /**
     * 请求的IP,从manifest中获取
     */
    private String mServerIp;

    /**
     * 请求的key，从manifest中获取
     */
    private String mAppKey;

    /**
     * accessToken，对于所有需要访问权限的请求都必须带accessToken，有些请求
     * 不需要，如游客访问等
     */
    private String mAccessToken;

    /**
     * 通过构造方法初始化Volley对象
     */
    public ProtalDataManager(Context context) {
        CloudVolley.init(context);
        mServerIp = ManifestMetadata.getServerIp(context);
        mAppKey = ManifestMetadata.getAppKey(context);
        mAccessToken = TokenManager.getAccessToken(context);
    }


    /**
     * 向服务器POST一条新数据
     * 这种操作针对的是单表的操作。
     *
     * @return PostMethod 通过method去构造body，header等信息
     */
    public PostMethod postData(CloudData cloudData) {
        Post post = new Post(mServerIp, mAppKey, mAccessToken);
        return post.post(cloudData);
    }


    /**
     * 向服务器POST一条新数据
     * 这种操作针对的是多表关联的操作。
     *
     * @return PostMethod 通过method去构造body，header等信息
     */
    public PostMethod postSubData(Class parentClass, String parentId, CloudData subData) {
        Post post = new Post(mServerIp, mAppKey, mAccessToken);
        return post.postSubData(parentClass, parentId, subData);
    }

}
