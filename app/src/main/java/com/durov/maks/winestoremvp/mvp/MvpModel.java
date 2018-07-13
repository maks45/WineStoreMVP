package com.durov.maks.winestoremvp.mvp;

import android.companion.CompanionDeviceManager;

import com.durov.maks.winestoremvp.data.Store;
import com.durov.maks.winestoremvp.data.StoreList;

import java.util.List;

public interface MvpModel {
    void loadDataFromDatabase(LoadDataCallback loadDataCallback);
    void loadDataFromNetwork(int nextPage, LoadDataCallback loadDataCallback);
    void saveStoresListToDatabase(List<Store> stores);
    interface LoadDataCallback {
        void onLoadComplete(StoreList storeList);
        void onLoadError(Throwable throwable);
    }
}
