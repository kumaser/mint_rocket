package com.mintrocket;


import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    private static ApiClass apiClass;

    @Override
    public void onCreate() {
        super.onCreate();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiClass = retrofit.create(ApiClass.class);
    }

    public static ApiClass getApi() {
        return apiClass;
    }
}
