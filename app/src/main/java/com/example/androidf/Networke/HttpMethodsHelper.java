package com.example.androidf.Networke;

import com.google.gson.Gson;
import com.hjq.gson.factory.GsonFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpMethodsHelper {

    final String TAG = "HttpMethods";

    Retrofit _retrofit;
    APIService _apiService;

    /* ============================== 单例 ==================================== */
    private HttpMethodsHelper() {
        OkHttpClient.Builder okClient = new OkHttpClient.Builder();
        okClient.connectTimeout(10, TimeUnit.SECONDS);
        okClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
//               Content-Type:  application/x-www-form
                Request request = chain.request().newBuilder()
                        .addHeader("Content-Type", "application/json")
//                        .addHeader("Accept-Encoding", "gzip, deflate")
//                        .addHeader("Connection", "keep-alive")
//                        .addHeader("Accept", "*/*")
//                        .addHeader("Cookie", "add " + "cookies here")
                        .build();
                return chain.proceed(request);
            }
        });

        _retrofit =
                new Retrofit.Builder()
                        .baseUrl("https://c.dev.linylife.cn/api/")
                        .addConverterFactory(GsonConverterFactory.create(GsonFactory.getSingletonGson()))
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .client(okClient.build())
                        .build();
        _apiService = _retrofit.create(APIService.class);

    }

    public static HttpMethodsHelper getInstance() {
        return SingletionInternalClassHolder.instance;
    }

    private static class SingletionInternalClassHolder {
        private static final HttpMethodsHelper instance = new HttpMethodsHelper();
    }







    /// 获取验证码
    public void getVerificationCode(HashMap<String, Object> hashMap, Observer<Object> observer) {
        RequestBody requestBody = getRequestBody(hashMap);
        Observable observable = _apiService.getVerificationCode(requestBody);
//        .map(new Function<String, TestBean>() { // 加工传递的数据
//            @Override
//            public TestBean apply(String s) throws Exception {
//                Log.w(TAG, "apply--" + Thread.currentThread().getName());
//                Gson gson = new Gson();
//                获取单例的 Gson 对象（已处理容错）
//                Gson gson = GsonFactory.getSingletonGson();
//                TestBean currentUseInfo = gson.fromJson(s, TestBean.class);
//                return currentUseInfo;
//            }
//        })

        toSubscribe(observable, observer);
    }


    /// 登录
    public void login(HashMap<String, Object> hashMap, Observer<Object> observer) {
        RequestBody requestBody = getRequestBody(hashMap);
        Observable observable = _apiService.login(requestBody);
//        .map(new Function<String, TestBean>() { // 加工传递的数据
//            @Override
//            public TestBean apply(String s) throws Exception {
//                Log.w(TAG, "apply--" + Thread.currentThread().getName());
//                Gson gson = new Gson();
//                获取单例的 Gson 对象（已处理容错）
//                Gson gson = GsonFactory.getSingletonGson();
//                TestBean currentUseInfo = gson.fromJson(s, TestBean.class);
//                return currentUseInfo;
//            }
//        })

        toSubscribe(observable, observer);
    }



/* ============================= 公共方法 ===================================== */

    /*
     * HashMap 转  RequestBody
     * */
    public RequestBody getRequestBody(HashMap<String, Object> hashMap) {
        StringBuffer data = new StringBuffer();
        if (hashMap != null && hashMap.size() > 0) {
            // Gson gson = new Gson();
            // 获取单例的 Gson 对象（已处理容错）
            Gson gson = GsonFactory.getSingletonGson();
            String json = gson.toJson(hashMap);
            RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);
            return requestBody;
        }
        return null;

    }

    /*
    *
    * 封装 subscribe 设置
    * */
    private void toSubscribe(Observable observable, Observer observer) {
        observable
                .compose(new TransformerHelper())
                .subscribe(observer);
    }

}
