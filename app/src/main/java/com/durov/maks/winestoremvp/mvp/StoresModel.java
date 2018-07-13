package com.durov.maks.winestoremvp.mvp;
import com.durov.maks.winestoremvp.data.Store;
import com.durov.maks.winestoremvp.data.StoreList;
import com.durov.maks.winestoremvp.database.StoreDao;
import com.durov.maks.winestoremvp.retrofit.RequestProductListInterface;
import com.durov.maks.winestoremvp.retrofit.RequestStoreListInterface;
import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static com.durov.maks.winestoremvp.Constants.STORES_PER_PAGE;

public class StoresModel implements MvpModel{

    private CompositeDisposable compositeDisposable;
    private StoreDao storeDao;
    private RequestStoreListInterface requestStoreListInterface;

    public StoresModel(StoreDao storeDao, RequestStoreListInterface requestStoreListInterface){
        compositeDisposable = new CompositeDisposable();
        this.storeDao = storeDao;
        this.requestStoreListInterface = requestStoreListInterface;
    }

    @Override
    public void loadDataFromDatabase(LoadDataCallback loadDataCallback) {
        compositeDisposable.add(Single.fromCallable(
                new StoresModel.CallableGetStoresFromDb())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Store>>() {
                    @Override
                    public void accept(List<Store> stores) throws Exception {
                        loadDataCallback.onLoadComplete(new StoreList(stores,null));
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(final Throwable throwable) throws Exception {
                        loadDataCallback.onLoadError(throwable);
                    }
                }));
    }

    @Override
    public void loadDataFromNetwork(int nextPage, LoadDataCallback loadDataCallback){
        compositeDisposable.add(
                requestStoreListInterface
                .register(String.valueOf(nextPage), String.valueOf(STORES_PER_PAGE))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<StoreList>() {
                    @Override
                    public void accept(StoreList storeList) throws Exception {
                        loadDataCallback.onLoadComplete(storeList);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        loadDataCallback.onLoadError(throwable);
                    }
                }));
    }

    @Override
    public void saveStoresListToDatabase(List<Store> stores){
        compositeDisposable.add(Completable.fromCallable(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                storeDao.insert(stores);
                //Log.d("Write db in thread",Thread.currentThread().getName());
                return null;
            }
        })
                .subscribeOn(Schedulers.io())
                .subscribe());

    }
    public void clearCompositeDisposable(){
        compositeDisposable.clear();
    }

    class CallableGetStoresFromDb implements Callable<List<Store>> {
        @Override
        public List<Store> call() throws Exception {
            return storeDao.getAll();
        }
    }
}
