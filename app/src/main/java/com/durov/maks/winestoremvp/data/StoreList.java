package com.durov.maks.winestoremvp.data;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class StoreList {

    @SerializedName("result")
    private List<Store> stores;
    @SerializedName("pager")
    private Pager pager;

    public StoreList() {
    }


    public StoreList(List<Store> stores, Pager pager) {
        this.stores = stores;
        this.pager = pager;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores (List<Store> stores) {
        this.stores = stores;
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }

}

