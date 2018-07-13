package com.durov.maks.winestoremvp.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.durov.maks.winestoremvp.data.Store;


@Database(entities = {Store.class}, version = 1,exportSchema = false)
public abstract class StoreDatabase extends RoomDatabase{
    public abstract StoreDao storeDao();
}
