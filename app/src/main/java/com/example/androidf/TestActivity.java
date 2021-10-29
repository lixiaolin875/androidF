package com.example.androidf;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.androidf.databinding.ActivityTestBinding;

public class TestActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    ActivityTestBinding binding;

    private RadioGroup rg_tab_bar;
    private RadioButton rb_home;
    private RadioButton rb_message;
    private RadioButton rb_mine;

    //Fragment Object
    private HomeFragment homeFragment;
    private MessageFragment messageFragment;
    private MineFragment mineFragment;
    private FragmentManager fManager;
//    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fManager = getFragmentManager();
        rg_tab_bar = binding.rgTabBar;
        rg_tab_bar.setOnCheckedChangeListener(this);

        rb_home = binding.rbb1;
        rb_message = binding.rbb2;
        rb_mine = binding.rbb3;
        rb_home.setChecked(true);

        initView();

    }



    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction fTransaction = fManager.beginTransaction();
        hideAllFragment(fTransaction);

//        switch (checkedId){
//            case R.id.rbb_1:
//                if(homeFragment == null){
//                    homeFragment = new HomeFragment();
//                    fTransaction.add(R.id.ly_content, homeFragment, "HomeFragment");
//                }else{
//                    fTransaction.show(homeFragment);
//                }
//                break;
//            case R.id.rbb_2:
//                if(messageFragment == null){
//                    messageFragment = new MessageFragment();
//                    fTransaction.add(R.id.ly_content, messageFragment, "Fragment2");
//                }else{
//                    fTransaction.show(messageFragment);
//                }
//                break;
//            case R.id.rbb_3:
//                if(mineFragment == null){
//                    mineFragment = new MineFragment();
//                    fTransaction.add(R.id.ly_content, mineFragment, "Fragment3");
//                }else{
//                    fTransaction.show(mineFragment);
//                }
//                break;
//        }
//        fTransaction.commit();


    }


     public void initView() {

         //定义底部标签图片大小和位置
         Drawable drawable_news = getResources().getDrawable(R.drawable.logo_home_select);
         //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
         drawable_news.setBounds(0, 0, 96, 96);
         //设置图片在文字的哪个方向
         rb_home.setCompoundDrawables(null, drawable_news, null, null);

         //定义底部标签图片大小和位置
         Drawable drawable_live = getResources().getDrawable(R.drawable.logo_home_select);
         //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
         drawable_live.setBounds(0, 0, 96, 96);
         //设置图片在文字的哪个方向
         rb_message.setCompoundDrawables(null, drawable_live, null, null);

         //定义底部标签图片大小和位置
         Drawable drawable_tuijian = getResources().getDrawable(R.drawable.logo_home_select);
         //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
         drawable_tuijian.setBounds(0, 0, 96, 96);
         //设置图片在文字的哪个方向
         rb_mine.setCompoundDrawables(null, drawable_tuijian, null, null);

     }

    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
//        if(homeFragment != null)fragmentTransaction.hide(homeFragment);
//        if(messageFragment != null)fragmentTransaction.hide(messageFragment);
//        if(mineFragment != null)fragmentTransaction.hide(mineFragment);
    }

}