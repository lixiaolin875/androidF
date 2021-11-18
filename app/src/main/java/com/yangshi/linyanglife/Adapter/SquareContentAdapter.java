package com.yangshi.linyanglife.Adapter;

import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.deadline.statebutton.StateImageView;
import com.yangshi.linyanglife.Model.SquareContentModel;
import com.yangshi.linyanglife.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * @author rolli1
 * @packageName com.yangshi.linyanglife.Adapter
 * @fileName SquareContentAdapter
 * @Copyright 2021/11/18
 * @des
 */
public class SquareContentAdapter extends BaseQuickAdapter<SquareContentModel, BaseViewHolder> {

    private ArrayList<SquareContentModel> dataList;

    public SquareContentAdapter(int layoutResId) {
        super(layoutResId);
    }

    public SquareContentAdapter(int layoutResId, ArrayList<SquareContentModel> dataList) {
        super(layoutResId, dataList);

        this.dataList = dataList;
    }


    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, SquareContentModel squareContentModel) {

        StateImageView icon_content = baseViewHolder.getView(R.id.icon_content);
        TextView content_tv = baseViewHolder.getView(R.id.content_tv);



    }
}
