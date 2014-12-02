package com.cvte.protal.sdk.data;


import android.content.Context;

import com.cvte.protal.sdk.data.post.Post;
import com.cvte.protal.sdk.data.post.PostMethod;

/**
 * Package : com.cvte.protal.sdk.data
 * Author : jacob
 * Date : 14-12-1
 * Description : 这个类是用来统一调用GET，POST，PATCH，DELETE方法的对外功能入口
 */
public final  class ProtalDataManager {

    /**
     * 请求的IP,从manifest中获取
     */
    private String mServerIp;

    /**
     * 请求的key，从manifest中获取
     */
    private String mAppKey;


    /**
     * 通过构造方法初始化Volley对象
     */
    public ProtalDataManager(Context context) {
        CloudVolley.init(context);
    }


    /**
     * 向服务器POST一条新数据
     *
     * @return PostMethod 通过method去构造body，header等信息
     */
    public PostMethod postData(CloudData cloudData) {
        Post post = new Post(mServerIp, mAppKey);
        return post.post(cloudData);
    }

}
