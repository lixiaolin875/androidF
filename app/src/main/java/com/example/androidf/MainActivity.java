package com.example.androidf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button mBtn;
    Button mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtn = findViewById(R.id.code_btn);
        mBtn.setOnClickListener(this);

        mLogin = findViewById(R.id.login_btn);
        mLogin.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.code_btn) {
            HttpMethodsHelper httpMethods = HttpMethodsHelper.getInstance();
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("telephone","13515483993");
            httpMethods.getVerificationCode(hashMap, new ObserverHelper<Object>(this) {
                @Override
                public void onNext(Object obj) {
                    super.onNext(obj);
                    Toast.makeText(MainActivity.this,"成功",Toast.LENGTH_SHORT).show();
                }
            });
        }else {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("telephone","13515483993");
            hashMap.put("verificationCode","067774");

            HttpMethodsHelper httpMethods = HttpMethodsHelper.getInstance();
            httpMethods.login(hashMap, new ObserverHelper<Object>(this) {
                @Override
                public void onNext(Object obj) {
                    super.onNext(obj);
                    Toast.makeText(MainActivity.this,"成功",Toast.LENGTH_SHORT).show();
                }
            });
        }


    }
}