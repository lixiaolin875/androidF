package com.example.androidf.Networke;


import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIService {

    @POST("v1/open/account/getVerificationCode")
    Observable<Object> getVerificationCode(@Body RequestBody body);

    @POST("v1/open/account/loginWithVerificationCode")
    Observable<Object> login(@Body RequestBody body);

}
