package com.gavynzhang.mvpzhihudaily.config;

import com.gavynzhang.mvpzhihudaily.model.entities.latest.Latest;

import java.util.Observable;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by GavynZhang on 2016/11/25 15:01.
 */

public interface APIInterface {
    @GET()
    Call<String> getLatest();
}
