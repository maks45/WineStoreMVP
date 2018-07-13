package com.durov.maks.winestoremvp.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.durov.maks.winestoremvp.data.Store;

import java.util.List;


@Dao
public interface StoreDao {

        @Query("SELECT * FROM store")
        List<Store> getAll();

        @Query("SELECT * FROM store WHERE id IN (:storesIds)")
        List<Store> loadAllByIds(int[] storesIds);

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insert(List<Store> stores);

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insert(Store store);

        @Update
        void update(Store store);

        @Delete
        void delete(Store store);
    }
