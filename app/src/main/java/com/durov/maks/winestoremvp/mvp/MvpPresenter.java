package com.durov.maks.winestoremvp.mvp;

import com.durov.maks.winestoremvp.data.StoreList;

public interface MvpPresenter {
    void attachView(MvpView mvpView);
    void detachView();
}
