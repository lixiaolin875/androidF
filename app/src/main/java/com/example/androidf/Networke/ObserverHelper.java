package com.example.androidf.Networke;


import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class ObserverHelper<T> implements Observer<T> {

    final String TAG = "ProgressObserver";

    private Activity activity;
    public ObserverHelper(Activity activity) {
        this.activity = activity;
    }

    //这是新加入的方法，在订阅后发送数据之前，
    //会首先调用这个方法，而Disposable可用于取消订阅
    //当订阅后，会首先调用这个方法，其实就相当于onStart()，
    //传入的Subscription 参数可以用于请求数据或者取消订阅
    @Override
    public void onSubscribe(Disposable d) {
        Log.d(TAG, "onSubscribe: ");

        if (!ObserverHelper.isNetworkConnected(activity)) {
            Toast.makeText(activity, "当前网络不可用，请检查网络情况", Toast.LENGTH_SHORT).show();
            d.dispose();
            // 一定要调用下面这一句
            onComplete();
        }
    }

    @Override
    public void onError(Throwable e) {
        Log.d(TAG, "onError: ");
    }

    @Override
    public void onComplete() {
        Log.d(TAG, "onComplete: ");
    }

    @Override
    public void onNext (T t) {

        Log.d(TAG, "onNext: ");
    }

    /**
     * 网络连接是否正常
     *
     * @return true:有网络    false:无网络
     */
    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }

}
