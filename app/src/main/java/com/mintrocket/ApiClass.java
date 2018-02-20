package com.mintrocket;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiClass {
    @GET("/repositories")
    Call<List<Repository>> getData(@Query("since") int since);
}
