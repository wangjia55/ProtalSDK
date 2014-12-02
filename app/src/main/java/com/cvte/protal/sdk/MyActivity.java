package com.cvte.protal.sdk;

import android.app.Activity;
import android.os.Bundle;

import com.cvte.protal.sdk.data.ProtalDataManager;
import com.cvte.protal.sdk.data.listener.ProtalResponseListener;
import com.cvte.protal.sdk.data.method.CloudMethod;
import com.cvte.sdk.demo.Person;
import com.cvte.sdk.demo.Student;

import org.json.JSONObject;

import java.util.HashMap;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        ProtalDataManager manager = new ProtalDataManager(getApplicationContext());
        manager.postData(new Student()).execute(
                new ResponseListener());


        manager.postSubData(Person.class,"123",new Student())
                .setRelation(CloudMethod.Relation.ONE_TO_MANY)
                .addHeader(new HashMap<String, String>())
                .addBody(new JSONObject()).execute(
                new ResponseListener());





    }

    private class ResponseListener extends ProtalResponseListener {

        @Override
        public void get(String response) {
            super.get(response);
        }

        @Override
        public void Exception(Exception e) {

        }
    }
}
