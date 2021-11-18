package com.yangshi.linyanglife.Adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yangshi.linyanglife.Model.MyModel;
import com.yangshi.linyanglife.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class MyAdapter extends BaseQuickAdapter<MyModel, BaseViewHolder> {

    List<MyModel> dataList = new ArrayList<MyModel>();

    public MyAdapter(int layoutResId) {
        super(layoutResId);
    }

    public MyAdapter(int layoutResId, @Nullable List<MyModel> data) {
        super(layoutResId, data);
        dataList = data;
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, MyModel myModel) {
        baseViewHolder.setText(R.id.tv_title, myModel.getTitle());
        ImageView imageView = baseViewHolder.getView(R.id.iv_img);
        Glide.with(getContext()).load(myModel.getImageUrl())
                .transition(withCrossFade()) // 淡入淡出效果
                .into(imageView);

    }
}
