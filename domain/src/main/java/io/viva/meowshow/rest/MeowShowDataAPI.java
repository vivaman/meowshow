package io.viva.meowshow.rest;


import retrofit.Callback;
import retrofit.http.Headers;
import retrofit.http.POST;

public interface MeowShowDataAPI {

    @Headers("Msg:0")
    @POST("/")
    void getConfiguration(Callback<?> callback);

}
