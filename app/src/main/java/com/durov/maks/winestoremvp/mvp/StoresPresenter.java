package com.durov.maks.winestoremvp.mvp;

import android.util.Log;

import com.durov.maks.winestoremvp.data.Store;
import com.durov.maks.winestoremvp.data.StoreList;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.durov.maks.winestoremvp.Constants.STORES_PER_PAGE;
import static com.durov.maks.winestoremvp.Constants.TAG;

public class StoresPresenter implements MvpPresenter{

    private boolean isPageLast,loadNow,offlineMode;
    private int nextPage;
    private MvpView mvpView;
    private MvpModel mvpModel;
    private ArrayList<Store> stores;

    public StoresPresenter(MvpModel mvpModel){
        this.mvpModel = mvpModel;
        stores =new ArrayList<>();
        isPageLast = false;
        loadNow = false;
        offlineMode = false;
        nextPage = 1;
    }

    @Override
    public void attachView(MvpView mvpView) {
        this.mvpView = mvpView;
        if(stores.isEmpty()){
            this.loadStores();
        }
        else if(mvpView!=null){
            mvpView.dataChenge();
        }
        //Log.d(TAG,"view attached");
    }

    @Override
    public void detachView() {
        mvpView = null;
    }
    public ArrayList<Store> getStoresList(){
        return stores;
    }


    public void loadStores(){
        Log.d(TAG,"Presenter load stores");
        if(!isPageLast && !loadNow){
            loadNow = true;
        if(mvpView!=null){
            mvpView.setLoad(loadNow);
        }
        mvpModel.loadDataFromNetwork(nextPage, new MvpModel.LoadDataCallback() {
            @Override
            public void onLoadComplete(StoreList storeList){
                if(offlineMode){
                    offlineMode = false;
                    if(mvpView!=null){
                        mvpView.showYouAreOfflineToast(false);
                    }
                }
                stores.addAll(storeList.getStores());
                isPageLast = storeList.getPager().isFinalPage();
                nextPage = storeList.getPager().getNextPage();
                mvpModel.saveStoresListToDatabase(storeList.getStores());
                if(mvpView!=null){
                    mvpView.dataChenge();
                    loadNow = false;
                    mvpView.setLoad(loadNow);
                }
            }

            @Override
            public void onLoadError(Throwable throwable) {
                handleError(throwable);
                loadNow = false;
            }
        });
        }
    }
    private void handleError(Throwable throwable){
        if (throwable instanceof HttpException) {
            HttpException httpException = (HttpException) throwable;
            Log.i(TAG, throwable.getMessage() + " / " + throwable.getClass());
        }
        // A network error happened
        if (throwable instanceof IOException) {
            Log.i(TAG, throwable.getMessage() + " / " + throwable.getClass());
            offlineMode = true;
            if(mvpView!=null){
                mvpView.showYouAreOfflineToast(offlineMode);
            }
            mvpModel.loadDataFromDatabase(new MvpModel.LoadDataCallback(){
                @Override
                public void onLoadComplete(StoreList storeList) {
                    stores.clear();
                    stores.addAll(storeList.getStores());
                    nextPage = stores.size()/STORES_PER_PAGE+1;
                    loadNow =false;
                    if(mvpView!=null){
                        mvpView.dataChenge();
                        mvpView.setLoad(loadNow);
                    }
                }
                @Override
                public void onLoadError(Throwable throwable) {
                    throwable.printStackTrace();
                    loadNow = false;
                }
            });
        }
    }

}
