package com.cvte.protal.sdk.data.post;

import com.cvte.protal.sdk.data.method.CloudMethod;

/**
 * Package : com.cvte.protal.sdk.data.post
 * Author : jacob
 * Date : 14-12-1
 * Description : 这个类是用来xxx
 */
 public interface PostMethod extends CloudMethod {

    /**
     * 设置对象的关系，一般在post方法中使用，且用户多表关联
     */
    public PostMethod setRelation(Relation relation);

}
