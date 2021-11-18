package com.yangshi.linyanglife.Activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.next.easynavigation.view.EasyNavigationBar;
import com.yangshi.linyanglife.Adapter.SquareContentAdapter;
import com.yangshi.linyanglife.Fragment.BazaarFragment;
import com.yangshi.linyanglife.Fragment.ContentFragment;
import com.yangshi.linyanglife.Fragment.HomeFragment;
import com.yangshi.linyanglife.Fragment.MessageFragment;
import com.yangshi.linyanglife.Fragment.MineFragment;
import com.yangshi.linyanglife.Model.SquareContentModel;
import com.yangshi.linyanglife.R;
import com.yangshi.linyanglife.databinding.ActivityMainBinding;

import java.util.ArrayList;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class LYSquareActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding mainBinding;
    EasyNavigationBar tabar;
    TitleBar mTitleBar;

    Button recommendBtn; // 推荐
    Button focusBtn; // 关注
    Button neighborhoodBtn; // 邻里
    int currentId; // 当前顶部选择按钮
    RecyclerView squareRecyclerView; // 广场RecyclerView
    SquareContentAdapter squareAdapter; //
    ArrayList<SquareContentModel> dataList;

    private final String[] titleList = {"首页", "集市", "消息", "我的"};
    //未选中icon
    private final int[] normalIcon = {R.drawable.icon_home, R.drawable.icon_shopbasket,
            R.drawable.icon_message, R.drawable.icon_user};
    //选中时icon
    private final int[] selectIcon = {R.drawable.logo_home_select, R.drawable.icon_shopbasket_select,
            R.drawable.icon_message_select, R.drawable.icon_user_select};

    // TODO: 2021/11/17 - UI
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        dataList = new ArrayList<>();

        /// 创建底部导航栏
        initNavigationBar();

        /// 创建顶部导航栏
        initTabar();

        /// 创建UI
        creatUIKit();




    }

    /*
    * 设置顶部导航栏
    * */
    private void initNavigationBar() {
        /// 沉浸式
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        mTitleBar = mainBinding.titleBar;
        mTitleBar.setOnTitleBarListener(new OnTitleBarListener() {

            @Override
            public void onLeftClick(View view) {

            }

            @Override
            public void onTitleClick(View view) {

            }

            @Override
            public void onRightClick(View view) {

            }
        });
    }

    /*
    * 设置底部导航栏
    * */
    private void initTabar() {

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
                        Toast.makeText(LYSquareActivity.this, "点击了" + position, Toast.LENGTH_SHORT).show();
                        return false;
                    }

                    @Override
                    public boolean onTabReSelectEvent(View view, int position) {
                        Toast.makeText(LYSquareActivity.this, "ReSelect点击了" + position, Toast.LENGTH_SHORT).show();
                        return false;
                    }
                })
                .centerImageRes(R.drawable.icon_circle)
                .centerIconSize(50)    //中间加号图片的大小
                .centerLayoutHeight(50)   //包含加号的布局高度 背景透明  所以加号看起来突出一块
                .setOnCenterTabClickListener(new EasyNavigationBar.OnCenterTabSelectListener() {
                    @Override
                    public boolean onCenterTabSelectEvent(View view) {
                        Toast.makeText(LYSquareActivity.this, "ReSelect点击了center", Toast.LENGTH_SHORT).show();

                        return false;
                    }
                })
                .centerAsFragment(true)
                .build();
    }



    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        setStatusBarDrawable(this,R.drawable.back_view);

    }

    private void creatUIKit() {

        recommendBtn = mainBinding.recommendBtn;
        recommendBtn.setOnClickListener(this::onClick);
        focusBtn = mainBinding.focusBtn;
        focusBtn.setOnClickListener(this::onClick);
        neighborhoodBtn = mainBinding.neighborhoodBtn;
        neighborhoodBtn.setOnClickListener(this::onClick);


        currentId = R.id.recommend_btn;
        recommendBtn.setTextSize(24);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);

        squareRecyclerView = mainBinding.squareRecycleView;

        squareAdapter = new SquareContentAdapter(R.id.square_recycle_view, dataList);
        squareRecyclerView.setAdapter(squareAdapter);

    }


    // TODO: 2021/11/18 Action
    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.recommend_btn) {
            currentId = R.id.recommend_btn;
        }else if (v.getId() == R.id.focus_btn) {
            currentId = R.id.focus_btn;
        }else if (v.getId() == R.id.neighborhood_btn) {
            currentId = R.id.neighborhood_btn;
        }
        recommendBtn.setTextSize(16);
        focusBtn.setTextSize(16);
        neighborhoodBtn.setTextSize(16);
        if (currentId == R.id.recommend_btn) {
            recommendBtn.setTextSize(24);
        }else if (currentId == R.id.focus_btn) {
            focusBtn.setTextSize(24);
        }else if (currentId == R.id.neighborhood_btn) {
            neighborhoodBtn.setTextSize(24);
        }


//        if (v.getId() == R.id.code_btn) {
//            HashMap<String, Object> hashMap = new HashMap<>();
//            hashMap.put("telephone", "13515483993");
//
//            HttpMethodsHelper httpMethods = HttpMethodsHelper.getInstance();
//            httpMethods.getVerificationCode(hashMap, new ObserverHelper<Object>(this) {
//                @Override
//                public void onNext(Object obj) {
//                    super.onNext(obj);
//                    Toast.makeText(LYSquareActivity.this, "成功", Toast.LENGTH_SHORT).show();
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
//                    Toast.makeText(LYSquareActivity.this, resultMap.get("msg").toString(),
//                            Toast.LENGTH_SHORT).show();
//                }
//            });

//            ActivityUtils.startActivity(new Intent(getApplicationContext(), TestActivity.class));
//        }


    }


    // TODO: 2021/11/18 private
    /**
     * 设置状态栏颜色背景图
     * @param activity
     * @param id
     */
    public static void setStatusBarDrawable(Activity activity, @DrawableRes int id) {
        //利用反射机制修改状态栏背景
        int identifier = activity.getResources().getIdentifier("statusBarBackground", "id", "android");
        View statusBarView = activity.getWindow().findViewById(identifier);
        if (statusBarView != null) {
            statusBarView.setBackgroundResource(id);
        }
    }

}