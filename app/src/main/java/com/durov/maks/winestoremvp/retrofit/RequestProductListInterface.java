package com.durov.maks.winestoremvp.retrofit;

import com.durov.maks.winestoremvp.data.StoreList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RequestProductListInterface {
        @GET("lcboapi.com/products?store_id={@store}&page ={@page}")
        Observable<StoreList> register(@Query(value = "page", encoded = true) String page, @Query(value = "store", encoded = true) String store);
}

