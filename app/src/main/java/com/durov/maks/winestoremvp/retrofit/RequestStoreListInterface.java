package com.durov.maks.winestoremvp.retrofit;

import com.durov.maks.winestoremvp.data.StoreList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RequestStoreListInterface {
    @GET("stores/?page={@page}&per_page={@per_page}&order=id.asc")
    Observable<StoreList> register(@Query(value = "page", encoded = true) String page
            , @Query(value = "per_page", encoded = true) String per_page);
}
