package com.durov.maks.winestoremvp;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.durov.maks.winestoremvp.database.StoreDao;
import com.durov.maks.winestoremvp.database.StoreDatabase;
import com.durov.maks.winestoremvp.database.StoreDatabaseHelper;
import com.durov.maks.winestoremvp.mvp.StoresModel;
import com.durov.maks.winestoremvp.mvp.StoresPresenter;
import com.durov.maks.winestoremvp.retrofit.RequestProductListInterface;
import com.durov.maks.winestoremvp.retrofit.RequestStoreListInterface;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.durov.maks.winestoremvp.Constants.DATABASE_NAME;
import static com.durov.maks.winestoremvp.Constants.ROOT_URL;


public class StoreApplication extends Application{

    private RequestStoreListInterface requestStoreListInterface;
    private RequestProductListInterface requestProductListInterface;
    private StoreDao storeDao;
    private StoresPresenter storesPresenter;
    private StoresModel storesModel;

    @Override
    public void onCreate() {
        super.onCreate();
        //storeDatabaseHelper = new StoreDatabaseHelper(this);
        requestStoreListInterface = new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(RequestStoreListInterface.class);
        requestProductListInterface = new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(RequestProductListInterface.class);
        StoreDatabase storeDatabase = Room
                .databaseBuilder(getApplicationContext(), StoreDatabase.class,DATABASE_NAME)
               // .allowMainThreadQueries() //need if you work in ui thread
                .build();
        storeDao = storeDatabase.storeDao();
        storesModel = new StoresModel(storeDao,requestStoreListInterface);
        storesPresenter = new StoresPresenter(storesModel);


    }

    public StoresPresenter getStoresPresenter() {
        return storesPresenter;
    }
}
