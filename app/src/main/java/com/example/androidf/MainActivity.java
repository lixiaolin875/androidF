package com.example.androidf;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.androidf.databinding.ActivityMainBinding;
import com.next.easynavigation.view.EasyNavigationBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button mBtn;
    Button mLogin;
    ActivityMainBinding mainBinding;
    ImageView mImageView;
    EasyNavigationBar tabar;

    private String[] titleList = {"首页", "发现", "消息", "我的"};
    //未选中icon
    private int[] normalIcon = {R.drawable.icon_home, R.drawable.icon_shopbasket,
            R.drawable.icon_message, R.drawable.icon_user};
    //选中时icon
    private int[] selectIcon = {R.drawable.logo_home_select, R.drawable.icon_shopbasket_select,
             R.drawable.icon_message_select, R.drawable.icon_user_select};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(mainBinding.getRoot());

//        mBtn = findViewById(R.id.code_btn);
//        mBtn.setOnClickListener(this);

//        mLogin = findViewById(R.id.login_btn);
//        mLogin.setOnClickListener(this);
//
//        mImageView = mainBinding.image;

        // 设置图片
//        Glide.with(this).load("https://img1.baidu.com/it/u=2285471789,1398773469&fm=26&fmt=auto").placeholder(R.drawable.ic_launcher_background).into(mImageView);

        ArrayList<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(new HomeFragment());
        fragments.add(new BazaarFragment());
        fragments.add(new ContentFragment());
        fragments.add(new MessageFragment());
        fragments.add(new MineFragment());

        tabar = mainBinding.navigationBar;
//        tabar.centerImageRes(R.drawable.icon_circle);
        tabar.titleItems(titleList)
                .normalIconItems(normalIcon)
                .selectIconItems(selectIcon)
                .fragmentList(fragments)
                .fragmentManager(getSupportFragmentManager())
                .mode(EasyNavigationBar.NavigationMode.MODE_ADD)
                .setOnTabClickListener(new EasyNavigationBar.OnTabClickListener() {
                    @Override
                    public boolean onTabSelectEvent(View view, int position) {
                        Toast.makeText(MainActivity.this, "点击了" + position, Toast.LENGTH_SHORT).show();
                        return false;
                    }

                    @Override
                    public boolean onTabReSelectEvent(View view, int position) {
                        Toast.makeText(MainActivity.this, "ReSelect点击了" + position, Toast.LENGTH_SHORT).show();
                        return false;
                    }
                })
                .centerImageRes(R.drawable.icon_circle)
                .centerIconSize(50)    //中间加号图片的大小
                .centerLayoutHeight(50)   //包含加号的布局高度 背景透明  所以加号看起来突出一块
                .setOnCenterTabClickListener(new EasyNavigationBar.OnCenterTabSelectListener() {
                    @Override
                    public boolean onCenterTabSelectEvent(View view) {
                        Toast.makeText(MainActivity.this, "ReSelect点击了center" , Toast.LENGTH_SHORT).show();

                        return false;
                    }
                })
                .centerAsFragment(true)
                .build();


    }


    @Override
    public void onClick(View v) {

//        if (v.getId() == R.id.code_btn) {
//            HashMap<String, Object> hashMap = new HashMap<>();
//            hashMap.put("telephone", "13515483993");
//
//            HttpMethodsHelper httpMethods = HttpMethodsHelper.getInstance();
//            httpMethods.getVerificationCode(hashMap, new ObserverHelper<Object>(this) {
//                @Override
//                public void onNext(Object obj) {
//                    super.onNext(obj);
//                    Toast.makeText(MainActivity.this, "成功", Toast.LENGTH_SHORT).show();
//                }
//            });
//        } else {
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

//            ActivityUtils.startActivity(new Intent(getApplicationContext(), TestActivity.class));
//        }


    }
}