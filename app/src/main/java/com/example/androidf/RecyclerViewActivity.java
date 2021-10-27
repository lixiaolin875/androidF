package com.example.androidf;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.androidf.databinding.ActivityRecyclerViewBinding;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    private ActivityRecyclerViewBinding binding;
    private ArrayList<MyModel> datas;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRecyclerViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //模拟的数据（实际开发中一般是从网络获取的）
        datas = new ArrayList<MyModel>();
        MyModel model;
        for (int i = 0; i < 15; i++) {
            model = new MyModel();
            model.setTitle("我是第" + i + "条标题");
            model.setImageUrl("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Faliyunzixunbucket.oss-cn-beijing.aliyuncs.com%2Fjpg%2F44beef795460f5ef97de7950eb9006cf.jpg%3Fx-oss-process%3Dimage%2Fresize%2Cp_100%2Fauto-orient%2C1%2Fquality%2Cq_90%2Fformat%2Cjpg%2Fwatermark%2Cimage_eXVuY2VzaGk%3D%2Ct_100&refer=http%3A%2F%2Faliyunzixunbucket.oss-cn-beijing.aliyuncs.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1637906866&t=12c3e47cb517879ab4c2ca4939a26148");
            datas.add(model);
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);


        binding.myRecyclerView.setLayoutManager(gridLayoutManager);
        myAdapter = new MyAdapter(R.layout.item_rv, datas);
        binding.myRecyclerView.setAdapter(myAdapter);

        View headView = LayoutInflater.from(this).inflate(R.layout.head_view_rv,null);
        myAdapter.addHeaderView(headView);

    }


}