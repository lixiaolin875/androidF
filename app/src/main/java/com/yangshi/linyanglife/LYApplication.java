package com.yangshi.linyanglife;

import android.app.Application;

import com.hjq.toast.ToastUtils;
import com.hjq.toast.style.BlackToastStyle;

/**
 * @author xl
 * @packageName com.yangshi.androidf
 * @fileName LYApplication
 * @Copyright 2021/11/18
 * @des
 */
public class LYApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        // 初始化 Toast 框架
        ToastUtils.init(this);
        ToastUtils.setStyle(new BlackToastStyle());

    }
}
