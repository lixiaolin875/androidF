package com.example.androidf;

import android.app.Application;

import com.hjq.toast.ToastUtils;

/**
 * @author xl
 * @packageName com.example.androidf
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

    }
}
