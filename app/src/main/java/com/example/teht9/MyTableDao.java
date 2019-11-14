package com.example.teht9;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MyTableDao {

    @Query("SELECT * FROM myentity ORDER BY id desc")
    List<MyEntity> getAllInDescendingOrder();

    @Query("SELECT user FROM myentity")
    List<MyEntity> getUsers();

    @Query("SELECT * FROM myEntity2")
    List<MyEntity2> getLoginInfo();

    @Insert
    void InsertMyEntity2(MyEntity2 myEntity2);

    /*@Insert
    void InsertMyEntity(MyEntity myentity);

    @Delete
    void DeleteMyEntity(MyEntity myentity);*/

}
