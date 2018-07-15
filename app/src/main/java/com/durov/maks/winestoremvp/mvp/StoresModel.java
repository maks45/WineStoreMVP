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


    private StoreDao storeDao;
    private RequestStoreListInterface requestStoreListInterface;

    public StoresModel(StoreDao storeDao, RequestStoreListInterface requestStoreListInterface){
        this.storeDao = storeDao;
        this.requestStoreListInterface = requestStoreListInterface;
    }


    @Override
    public Single loadDataFromDatabase() {
        return Single.fromCallable(new CallableGetStoresFromDb());
    }

    @Override
    public Single loadDataFromNetwork(int nextPage) {
        return Single.fromObservable(
                requestStoreListInterface
                        .register(String.valueOf(nextPage),String.valueOf(STORES_PER_PAGE)));
    }

    @Override
    public Completable saveStoresListToDatabase(List<Store> stores){
        return Completable.fromCallable(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                storeDao.insert(stores);
                //Log.d("Write db in thread",Thread.currentThread().getName());
                return null;
            }
        });

    }

    class CallableGetStoresFromDb implements Callable<List<Store>> {
        @Override
        public List<Store> call() throws Exception {
            return storeDao.getAll();
        }
    }
}
