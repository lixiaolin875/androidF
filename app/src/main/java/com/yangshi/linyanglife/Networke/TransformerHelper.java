package com.yangshi.linyanglife.Networke;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class TransformerHelper implements ObservableTransformer {


    @Override
    public ObservableSource apply(Observable upstream) {
        return upstream.subscribeOn(Schedulers.io())
//                        .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
