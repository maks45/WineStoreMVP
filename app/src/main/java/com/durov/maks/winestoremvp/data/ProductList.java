package com.durov.maks.winestoremvp.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductList {

    @SerializedName("result")
    private List<Product> products;
    @SerializedName("pager")
    private Pager pager;

    public ProductList(List<Product> products, Pager pager) {
        this.products = products;
        this.pager = pager;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }
}
