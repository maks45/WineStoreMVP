package com.durov.maks.winestoremvp.mvp;

import android.companion.CompanionDeviceManager;

import com.durov.maks.winestoremvp.data.Store;
import com.durov.maks.winestoremvp.data.StoreList;

import java.util.List;
import java.util.function.Consumer;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface MvpModel {
    Single loadDataFromDatabase();
    Single loadDataFromNetwork(int nextPage);
    Completable saveStoresListToDatabase(List<Store> stores);
}
