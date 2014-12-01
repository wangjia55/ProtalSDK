package com.cvte.protal.sdk.data.post;

import com.android.volley.Request;
import com.cvte.protal.sdk.data.listener.ProtalResponseListener;
import com.cvte.protal.sdk.data.method.BaseProtalMethod;

/**
 * Package : com.cvte.protal.sdk.data.post
 * Author : jacob
 * Date : 14-12-1
 * Description : 这个类是用来xxx
 */
public class PostMethod extends BaseProtalMethod {
    @Override
    public void execute(ProtalResponseListener listener) {
        super.execute(listener);
    }

    @Override
    protected int getRestMethod() {
        return Request.Method.GET;
    }
}
