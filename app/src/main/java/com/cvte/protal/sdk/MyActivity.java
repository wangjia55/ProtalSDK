package com.cvte.protal.sdk;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cvte.protal.sdk.data.ProtalDataManager;
import com.cvte.protal.sdk.data.listener.ProtalResponseListener;
import com.cvte.protal.sdk.tools.LogUtils;


public class MyActivity extends Activity {

    private EditText mEditTextname;
    private EditText mEditTextpwd;
    private Button mButtonlogin;
    private ProtalDataManager mDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        mDataManager = new ProtalDataManager(getApplicationContext());
        ProtalDataManager.setDebugMode(true);
//        manager.postData(new Student()).execute(
//                new ResponseListener());
//
//
//        manager.postSubData(Person.class,"123",new Student())
//                .setRelation(CloudMethod.Relation.ONE_TO_MANY)
//                .addHeader(new HashMap<String, String>())
//                .addBody(new JSONObject()).execute(
//                new ResponseListener());


        initialize();
    }

    private void initialize() {
        mEditTextname = (EditText) findViewById(R.id.editText_name);
        mEditTextpwd = (EditText) findViewById(R.id.editText_pwd);
        mButtonlogin = (Button) findViewById(R.id.button_login);
        mButtonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDataManager.login(mEditTextname.getText().toString(),
                        mEditTextpwd.getText().toString())
                        .execute(new ResponseListener());
            }
        });

        findViewById(R.id.button_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDataManager.register(mEditTextname.getText().toString(),
                        mEditTextpwd.getText().toString())
                        .execute(new ResponseListener());
            }
        });
    }

    private class ResponseListener extends ProtalResponseListener {

        @Override
        public void get(String response) {
            super.get(response);
            LogUtils.LOGE("reponse:",response.toString());
        }

        @Override
        public void Exception(Exception e) {
            LogUtils.LOGE("Exception:",e.getMessage());
        }
    }
}
