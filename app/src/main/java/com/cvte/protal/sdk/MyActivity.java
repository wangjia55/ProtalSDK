package com.cvte.protal.sdk;

import android.app.Activity;
import android.os.Bundle;

import com.cvte.protal.sdk.data.CloudData;
import com.cvte.protal.sdk.data.ProtalDataManager;
import com.cvte.protal.sdk.data.ProtalResponse;
import com.cvte.protal.sdk.data.listener.ProtalResponseListener;
import com.cvte.protal.sdk.data.method.CloudMethod;

import org.json.JSONObject;

import java.util.HashMap;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        ProtalDataManager manager = new ProtalDataManager(getApplicationContext());
        manager.postData(new CloudData()).setRelation(CloudMethod.Relation.ONE_TO_MANY)
                .addHeader(new HashMap<String, String>())
                .addBody(new JSONObject()).execute(new ProtalResponseListener() {
            @Override
            public void post(ProtalResponse response) {
                super.post(response);
                response.getCode();
            }
        });
    }
}
