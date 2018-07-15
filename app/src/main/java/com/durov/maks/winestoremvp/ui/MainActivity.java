package com.durov.maks.winestoremvp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.durov.maks.winestoremvp.R;
import com.durov.maks.winestoremvp.StoreApplication;
import com.durov.maks.winestoremvp.mvp.MvpView;
import com.durov.maks.winestoremvp.mvp.StoresPresenter;
import com.durov.maks.winestoremvp.ui.adapters.StoreAdapter;
import com.durov.maks.winestoremvp.data.Store;
import static com.durov.maks.winestoremvp.Constants.EXTRA_STORE;

public class MainActivity extends AppCompatActivity implements MvpView {

    private StoresPresenter storesPresenter;
    private RecyclerView recyclerView;
    private StoreAdapter storeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


    }
    private void init(){
        storesPresenter = ((StoreApplication) getApplication()).getStoresPresenter();
        recyclerView = findViewById(R.id.main_activity_recycler_view);
        storeAdapter = new StoreAdapter(storesPresenter.getStoresList());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(storeAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(layoutManager.findFirstVisibleItemPosition()+ layoutManager.getChildCount() > storesPresenter.getStoresList().size()-3){
                    storesPresenter.loadStores();
                }
            }

        });
        storeAdapter.setOnClick(this::startStoreActivity);
        storesPresenter.attachView(this);
    }

    private void startStoreActivity(Store store){
        Intent intent = new Intent(this,StoreActivity.class);
        intent.putExtra(EXTRA_STORE,store);
        startActivity(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        storesPresenter.detachView();
        if(isFinishing()){
            ((StoreApplication) getApplication()).setStoresPresenterNull();
        }
    }


    @Override
    public void dataChenge() {
        recyclerView.post(() -> storeAdapter.notifyDataSetChanged());
    }

    @Override
    public void showYouAreOfflineToast(boolean isOffline) {
        if(isOffline){
            Toast.makeText(getApplicationContext(),"You are offline",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(),"Connection restored",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void setLoad(boolean isLoad) {
        storeAdapter.setLoadData(isLoad);
        recyclerView.post(()-> storeAdapter.notifyDataSetChanged());
    }
}
