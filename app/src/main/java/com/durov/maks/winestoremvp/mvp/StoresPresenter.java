package com.durov.maks.winestoremvp.mvp;

import android.util.Log;

import com.durov.maks.winestoremvp.data.Store;
import com.durov.maks.winestoremvp.data.StoreList;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static com.durov.maks.winestoremvp.Constants.STORES_PER_PAGE;
import static com.durov.maks.winestoremvp.Constants.TAG;

public class StoresPresenter implements MvpPresenter{

    private boolean isPageLast,loadNow,offlineMode;
    private int nextPage;
    private MvpView mvpView;
    private MvpModel mvpModel;
    private ArrayList<Store> storesArray;
    private CompositeDisposable compositeDisposable;

    public StoresPresenter(MvpModel mvpModel){
        compositeDisposable = new CompositeDisposable();
        this.mvpModel = mvpModel;
        storesArray =new ArrayList<>();
        isPageLast = false;
        loadNow = false;
        offlineMode = false;
        nextPage = 1;
    }

    @Override
    public void attachView(MvpView mvpView) {
        this.mvpView = mvpView;
        if(storesArray.isEmpty()){
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
        compositeDisposable.clear();
    }
    public ArrayList<Store> getStoresList(){
        return storesArray;
    }



    public void loadStores(){
        Log.d(TAG,"Presenter load stores");
        if(!isPageLast && !loadNow){
            loadNow = true;
        if(mvpView!=null){
            mvpView.setLoad(loadNow);
        }
        compositeDisposable.add(mvpModel.loadDataFromNetwork(nextPage)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<StoreList>() {
            @Override
            public void accept(StoreList storeList) throws Exception {
                loadNow = false;
                mvpView.setLoad(loadNow);
                isPageLast = storeList.getPager().isFinalPage();
                nextPage = storeList.getPager().getNextPage();
                storesArray.addAll(storeList.getStores());
                if(mvpView!=null){
                    mvpView.dataChenge();
                }
                compositeDisposable.add(mvpModel.saveStoresListToDatabase(storeList.getStores())
                .subscribeOn(Schedulers.io())
                .subscribe());
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                handleError(throwable);
            }
        }));

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
            compositeDisposable.add(
                    mvpModel.loadDataFromDatabase()
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Consumer<List<Store>>() {
                                @Override
                                public void accept(List<Store> stores) throws Exception {
                                    storesArray.clear();
                                    storesArray.addAll(stores);
                                    nextPage = stores.size() / STORES_PER_PAGE + 1;
                                    loadNow = false;
                                    if (mvpView != null) {
                                        mvpView.dataChenge();
                                        mvpView.setLoad(loadNow);
                                    }
                                }
                            }, new Consumer<Throwable>() {
                                @Override
                                public void accept(final Throwable throwable) throws Exception {
                                    throwable.printStackTrace();
                                }
                            }));

        }
    }

}
