package com.example.androidf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.blankj.utilcode.util.ActivityUtils;
import com.bumptech.glide.Glide;
import com.example.androidf.databinding.ActivityMainBinding;
import com.example.androidf.Networke.HttpMethodsHelper;
import com.example.androidf.Networke.ObserverHelper;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button mBtn;
    Button mLogin;
    ActivityMainBinding mainBinding;
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(mainBinding.getRoot());

//        mBtn = findViewById(R.id.code_btn);
//        mBtn.setOnClickListener(this);

        mLogin = findViewById(R.id.login_btn);
        mLogin.setOnClickListener(this);

        mImageView = mainBinding.image;

        // 设置图片
        Glide.with(this).load("https://img1.baidu.com/it/u=2285471789,1398773469&fm=26&fmt=auto")
                .placeholder(R.drawable.ic_launcher_background).into(mImageView);

    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.code_btn) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("telephone", "13515483993");

            HttpMethodsHelper httpMethods = HttpMethodsHelper.getInstance();
            httpMethods.getVerificationCode(hashMap, new ObserverHelper<Object>(this) {
                @Override
                public void onNext(Object obj) {
                    super.onNext(obj);
                    Toast.makeText(MainActivity.this, "成功", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
//            HashMap<String, Object> hashMap = new HashMap<>();
//            hashMap.put("telephone", "13515483993");
//            hashMap.put("verificationCode", "067774");
//
//            HttpMethodsHelper httpMethods = HttpMethodsHelper.getInstance();
//            httpMethods.login(hashMap, new ObserverHelper<Object>(this) {
//                @Override
//                public void onNext(Object obj) {
//                    super.onNext(obj);
//
//                    HashMap<String, Object> resultMap = (HashMap<String, Object>) obj;
//
//                    Toast.makeText(MainActivity.this, resultMap.get("msg").toString(),
//                            Toast.LENGTH_SHORT).show();
//                }
//            });

            ActivityUtils.startActivity(new Intent(getApplicationContext(), RecyclerViewActivity.class));
        }


    }
}