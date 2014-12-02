package com.cvte.protal.sdk.data.post;

import com.android.volley.Request;
import com.cvte.protal.sdk.data.CloudData;
import com.cvte.protal.sdk.data.method.BaseProtalMethodImpl;

/**
 * Package : com.cvte.protal.sdk.data.post
 * Author : jacob
 * Date : 14-12-1
 * Description : 这个类是用来xxx
 */
public class Post extends BaseProtalMethodImpl implements PostMethod {

    public Post(String severIp, String appKey, String accessToken) {
        super(severIp, appKey, accessToken);
    }

    @Override
    protected int getRestMethod() {
        return Request.Method.GET;
    }

    public PostMethod post(CloudData cloudData) {
        addPath(cloudData.getClass().getSimpleName().toLowerCase(), null);
        return this;
    }

    public PostMethod postSubData(Class parentClass, String parentId, CloudData subData) {
        addPath(parentClass.getSimpleName().toLowerCase(), parentId);
        addPath(subData.getClass().getSimpleName().toLowerCase(), null);
        return this;
    }

    @Override
    public PostMethod setRelation(Relation relation) {
        super.mRelation = relation;
        return this;
    }

}
