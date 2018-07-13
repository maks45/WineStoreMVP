package com.durov.maks.winestoremvp.mvp;


import com.durov.maks.winestoremvp.data.Store;

import java.util.List;

public interface MvpView {
    void dataChenge();
    void showYouAreOfflineToast(boolean isOffline);
    void setLoad(boolean isLoad);
}
